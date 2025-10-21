package dedede.infrastructure;

import java.io.*;
import java.util.List;

public class CSVManager {
    File file;
    BufferedReader input;
    BufferedWriter output;

    public CSVManager(File file) throws IOException {
        input = new BufferedReader(new FileReader(file));
        output = new BufferedWriter(new FileWriter(file));
        this.file = file;
    }

    public List<CSVRow> listAll() throws IOException {
        var lines = input.lines();
        return lines.map(CSVRow::FromLine).toList();
    }

    public void insertRow(CSVRow csvRow) throws IOException {
        output.write(csvRow.toLine());
        output.newLine();
    }
}
