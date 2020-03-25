package homework17.repositories;

import homework17.models.File;

import java.util.Optional;

public interface FileRepository extends CrudRepository<File, Long> {
    Optional<File> getFileById(Integer id);
}
