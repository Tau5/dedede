package dedede.repository;

import dedede.infrastructure.CSVManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CSVManager reader = null;
        try {
            reader = new CSVManager(new File("example.csv"));

            var rows = reader.listAll();

            for (var row : rows) {
               for (var field : row) {
                   System.out.print(field + "\t");
               }
                System.out.println();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
