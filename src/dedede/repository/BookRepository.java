package dedede.repository;

import dedede.domain.Book;
import dedede.infrastructure.CSVManager;

import java.io.File;
import java.io.IOException;

public class BookRepository implements IRepositorio<Book, Long> {
    CSVManager table;

    public BookRepository(File file) throws IOException {
       table = new CSVManager(file);
    }

    @Override
    public long count() {
        return table.listAll().stream().count() - 1;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Book findById(Long aLong) {
        return null;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public <S extends Book> S save(S entity) {
        return null;
    }
}
