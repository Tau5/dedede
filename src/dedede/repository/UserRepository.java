package dedede.repository;

import dedede.domain.User;
import dedede.infrastructure.CSVManager;

public class UserRepository implements IRepositorio<User, Long> {

    private CSVManager table;

    @Override
    public long count() {
        return (long) table.listAll().size() - 1;
    }

    @Override
    public void deleteById(Long id) {
        table.deleteRow(id.toString(), 0);
    }

    @Override
    public void deleteAll() {
        table.emptyTable();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

}
