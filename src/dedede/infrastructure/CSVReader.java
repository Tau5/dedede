package dedede.infrastructure;

import java.io.*;
import java.util.List;

public class CSVReader {
    File file;
    BufferedReader input;

    public CSVReader(File file) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(file));
        this.file = file;
    }

    public List<CSVRow> listAll() throws IOException {
        var lines = input.lines();
        return lines.map(CSVRow::FromLine).toList();
    }

}
