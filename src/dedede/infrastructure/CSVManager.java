package dedede.infrastructure;

import java.io.*;
import java.util.List;

public class CSVManager {
    File file;
    BufferedReader input;

    public CSVManager(File file) throws IOException {
        input = new BufferedReader(new FileReader(file));
        this.file = file;
    }

    public List<CSVRow> listAll() {
        var lines = input.lines();
        // Convert every line of the csv file to CSVRow with CSVRow.FromLine
        return lines
                .skip(1) // Skip header of csv
                .map(CSVRow::FromLine)
                .toList();
    }

    public void insertRow(CSVRow csvRow) throws IOException {
        try(var output = new BufferedWriter(new FileWriter(file, true))) {
            output.write(csvRow.toLine());
            output.newLine();
            output.flush();
        }
    }

    public void updateRow(String ID, int column, CSVRow csvRow) throws IOException {
        try(BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
            var lines = input.lines();
            lines.map(CSVRow::FromLine).toList().forEach(line -> {
                if (line.fields.get(column).equals(ID)) {
                    try {
                        output.write(csvRow.toLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    output.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
