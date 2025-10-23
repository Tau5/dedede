package dedede.infrastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    File file;
    ArrayList<CSVRow> rows;
    CSVRow header;

    public CSVManager(File file) throws IOException {
        this.file = file;
        try (var reader = new BufferedReader(new FileReader(file))) {
            var lines = reader
                    .lines()
                    .map(CSVRow::FromLine);
            this.rows = new ArrayList<>(lines.toList());
            this.header = this.rows.removeFirst();
        }
    }

    public List<CSVRow> listAll() {
        return this.rows;
    }

    public void saveFile() throws IOException {
        try(var output = new BufferedWriter(new FileWriter(file))) {
            output.write(header.toLine());
            output.newLine();
            rows.forEach(row -> {
                try {
                    output.write(row.toLine());
                    output.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            output.flush();
        }
    }

    public void updateRow(String ID, int column, CSVRow csvRow) throws IOException {
        for (int i = 0; i < rows.size(); i++) {
           var row = rows.get(i);
           if (row.fields.get(column).equals(ID)) {
              rows.set(i, csvRow);
           }
        }
    }

    public void insertRow(CSVRow csvRow) {
        rows.add(csvRow);
    }
}
