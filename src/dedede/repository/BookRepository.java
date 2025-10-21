package dedede.repository;

import dedede.domain.Book;
import dedede.infrastructure.CSVManager;
import dedede.infrastructure.CSVRow;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class BookRepository implements IRepositorio<Book, Long> {
    CSVManager table;

    public BookRepository(File file) throws IOException {
       table = new CSVManager(file);
    }

    private Book bookFromRow(CSVRow row) {
        return new Book(
                row.getLong(0).orElse(0L),
                row.getString(1).orElse(""),
                row.getString(2).orElse(""),
                row.getBoolean(3).orElse(false),
                row.getLong(4).orElse(0L),
                row.getInstant(5).orElse(Instant.EPOCH),
                row.getInstant(6).orElse(Instant.EPOCH)
        );
    }

    @Override
    public long count() {
        return (long) table.listAll().size() - 1;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean existsById(Long id) {
        var rows = table.listAll().stream().filter(t ->
                t.getLong(0).stream().anyMatch(rowId -> rowId.equals(id))
        );

        var maybeRow = rows.findAny();

        return maybeRow.isPresent();
    }

    @Override
    public Book findById(Long id) {
        var rows = table.listAll().stream().filter(t ->
            t.getLong(0).stream().anyMatch(rowId -> rowId.equals(id))
        );

        var maybeRow = rows.findAny();

        return maybeRow.map(this::bookFromRow).orElse(null);
    }

    @Override
    public Iterable<Book> findAll() {
        // Maps every CSVRow of the table to Book
        return table
                .listAll()
                .stream().map(this::bookFromRow)
                .toList();
    }

    private CSVRow bookToRow(Book book) {
        CSVRow row = new CSVRow(7);
        row.setLong(0, book.getID());
        row.setString(1, book.getTitel());
        row.setString(2, book.getAuthor());
        row.setBoolean(3, book.isBorrowed());
        row.setLong(4, book.getUserID());
        row.setInstant(5, book.getBorrowStart());
        row.setInstant(6, book.getBorrowEnd());

        return row;
    }

    @Override
    public <S extends Book> S save(S entity) {
        CSVRow row = bookToRow(entity);
        try {
            if (existsById(entity.getID())) {
                table.updateRow(row.getString(0).get(), 0, row);
            } else {
                table.insertRow(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }
}
