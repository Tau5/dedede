package dedede.repository;

public interface IRepository<E, ID> {
    E findOne(ID id);
}
