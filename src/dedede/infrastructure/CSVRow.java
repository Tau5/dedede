package dedede.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class CSVRow extends ArrayList<String> {

    static CSVRow FromLine(String line) {
        return new CSVRow(List.of(line.split(",")));
    }

    private CSVRow(List<String> str) {
        this.addAll(str);
    }

    String toLine() {
       StringBuffer b = new StringBuffer();
       for (int i = 0; i < this.size(); i++) {
           b.append(this.get(i));
           if (i != this.size() - 1) {
               b.append(",");
           }
       }

       return b.toString();
    }
}
