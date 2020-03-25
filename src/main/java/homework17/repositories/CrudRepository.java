package homework17.repositories;

import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<T> create(T model);

    Optional<T> read(String fileName);

    void update(T model);

    void delete(ID id);

}
