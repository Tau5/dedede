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
            var lines = reader.lines();
            this.header = CSVRow.FromLine(lines.findFirst().get());
            this.rows = new ArrayList<>(lines.map(CSVRow::FromLine).toList());
        }
    }

    public List<CSVRow> listAll() {
        return this.rows;
    }

    public void saveFile(CSVRow csvRow) throws IOException {
        try(var output = new BufferedWriter(new FileWriter(file, true))) {
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
        rows.forEach(row -> {
            if (row.equals(ID)) {
                row = csvRow;
            }
        });
    }

    public void insertRow(CSVRow csvRow) {
        rows.add(csvRow);
    }

    public void deleteRow(String ID) {
        rows.forEach(row -> {
            if (row.equals(ID)) {
                rows.remove(row);
            }
        });
    }
}
