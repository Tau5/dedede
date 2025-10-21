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

    public List<CSVRow> listAll() throws IOException {
        var lines = input.lines();
        // Convert every line of the csv file to CSVRow with CSVRow.FromLine
        return lines.map(CSVRow::FromLine).toList();
    }

    public void insertRow(CSVRow csvRow) throws IOException {
        var output = new BufferedWriter(new FileWriter(file, true));
        output.write(csvRow.toLine());
        output.newLine();
    }
}
