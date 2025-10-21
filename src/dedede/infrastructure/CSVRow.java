package dedede.infrastructure;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVRow {
    ArrayList<String> fields;

    static CSVRow FromLine(String line) {
        return new CSVRow(List.of(line.split(",")));
    }

    private CSVRow(List<String> fields) {
        this.fields = new ArrayList<>(fields);
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
        try {
            // If getLong returns Empty, return Empty
            // else, treat long as epoch seconds and convert to Option<Instant> containing instant
            return getLong(fieldIndex).map(Instant::ofEpochSecond);
        } catch (ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
