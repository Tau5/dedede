package dedede.repository;

import dedede.infrastructure.CSVManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CSVManager manager = null;
        try {
            manager = new CSVManager(new File("example.csv"));

            var rows = manager.listAll();

            for (var row : rows) {
                row.getLong(0).ifPresent(id -> {
                    System.out.println("id: " + id);
                });
                row.getString(1).ifPresent(nombre -> {
                    System.out.println("nombre: " + nombre);
                });
                row.getLong(2).ifPresent(num -> {
                    System.out.println("num: " + num);
                });
                row.getInstant(3).ifPresent(instant -> {
                    System.out.println("instant: " + instant);
                });
                row.getBoolean(4).ifPresent(bool -> {
                    System.out.println("boolean: " + bool);
                });
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
