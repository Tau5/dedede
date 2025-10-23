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
        try {
            input.close();
            input = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var lines = input.lines();
        // Convert every line of the csv file to CSVRow with CSVRow.FromLine
        return
    }

    public void insertRow(CSVRow csvRow) throws IOException {
        try(var output = new BufferedWriter(new FileWriter(file, true))) {
            output.write(csvRow.toLine());
            output.newLine();
            output.flush();
        }
    }

    public void updateRow(String ID, int column, CSVRow csvRow) throws IOException {
        input.close();
        input = new BufferedReader(new FileReader(file));
        var lines = input.lines().toList();
        input.close();
        try(BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
            lines.stream().map(CSVRow::FromLine).forEach(line -> {
                System.out.println(line.toLine());
                if (line.fields.get(column).equals(ID)) {
                    try {
                        output.write(csvRow.toLine());
                        output.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        output.write(line.toLine());
                        output.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            try {
                output.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        input.close();
    }
}
