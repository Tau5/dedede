package dedede.infrastructure;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class  CSVRow {
    protected  ArrayList<String> fields;

    static CSVRow FromLine(String line) {
        return new CSVRow(List.of(line.split(",")));
    }

    private CSVRow(List<String> fields) {
        this.fields = new ArrayList<>(fields);
    }

    public CSVRow(int size) {
        this.fields = new ArrayList<String>(size);
        for (int i = 0; i < size; i++) this.fields.add("");
    }

    String toLine() {
       StringBuffer b = new StringBuffer();
       for (int i = 0; i < fields.size(); i++) {
           b.append(fields.get(i));
           if (i != fields.size() - 1) {
               b.append(",");
           }
       }

       return b.toString();
    }

    public int length() {
        return fields.size();
    }

    public Optional<Long> getLong(int fieldIndex) {
        try {
            return Optional.of(
                    Long.parseLong(fields.get(fieldIndex))
            );
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public Optional<String> getString(int fieldIndex) {
        try {
            return Optional.of(fields.get(fieldIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public Optional<Instant> getInstant(int fieldIndex) {
        // If getLong returns Empty, return Empty
        // else, treat long as epoch seconds and convert to Option<Instant> containing instant
        return getLong(fieldIndex).map(Instant::ofEpochSecond);
    }

    public Optional<Boolean> getBoolean(int fieldIndex) {
        return getLong(fieldIndex).map(l -> {
            if (l == 0) {
                return false;
            } else {
                return true;
            }
        });
    }

    public void setLong(int fieldIndex, long value) throws ArrayIndexOutOfBoundsException {
        fields.set(fieldIndex, Long.toString(value));
    }

    public void setString(int fieldIndex, String value) throws ArrayIndexOutOfBoundsException {
        fields.set(fieldIndex, value);
    }

    public void setInstant(int fieldIndex, Instant value) throws ArrayIndexOutOfBoundsException {
        setLong(fieldIndex, value.getEpochSecond());
    }

    public void setBoolean(int fieldIndex, Boolean value) throws ArrayIndexOutOfBoundsException {
        if (value) {
            setLong(fieldIndex, 1);
        } else {
            setLong(fieldIndex, 0);
        }
    }
}
