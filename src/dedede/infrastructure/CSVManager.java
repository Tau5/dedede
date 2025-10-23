package dedede.infrastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    File file;
    ArrayList<CSVRow> rows;
    CSVRow header;

    /**
     * Constructor para modificar en memoria los archivos sin manejar el archivo en tiempo real
     * @param file
     *
     * @throws IOException
     */
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

    /**
     * Metodo para devolver la lista de las filas del archivo
     *
     * @return this.rows
     */
    public List<CSVRow> listAll() {
        return this.rows;
    }

    /**
     * Metodo para escribir de memoria a archivo
     *
     * @throws IOException
     */
    public void saveFile() throws IOException {
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

    /**
     * Metodo para modificar una fila, buscando a trabas de ID
     *
     * @param ID Identificador
     * @param csvRow Datos nuevos de la fila a modificar
     *
     * @throws IOException
     */
    public void updateRow(String ID, int column, CSVRow csvRow) throws IOException {
        for (int i = 0; i < rows.size(); i++) {
           var row = rows.get(i);
           if (row.fields.get(column).equals(ID)) {
              rows.set(i, csvRow);
           }
        }
    }

    /**
     * Metodo para insertar una nueva fila
     *
     * @param csvRow Nueva fila a insertar en la lista
     */
    public void insertRow(CSVRow csvRow) {
        rows.add(csvRow);
    }

    /**
     * Metodo para eliminar una fila, buscandola por Id
     *
     * @param ID Identificador de la fila
     */
    public void deleteRow(String ID) {
        rows.forEach(row -> {
            if (row.equals(ID)) {
                rows.remove(row);
            }
        });
    }
}
