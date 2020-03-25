package homework17.repositories;

import homework17.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Optional;

@Component
public class FileRepositoryImpl implements FileRepository {

    private static final String SQL_SELECT_BY_NAME =
            "select * from db8.file where fileName = ?";
    private static final String SQL_INSERT =
            "insert into db8.file (fileName, uploadUser, size, path, state, mimeType, extension) values (?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_SELECT_BY_ID =
            "select * from db8.file where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<File> userRowMapper = (row, rowNumber) ->
            File.builder()
                    .id(row.getLong("id"))
                    .fileName(row.getString("fileName"))
                    .uploadUser(row.getString("uploadUser"))
                    .size(row.getLong("size"))
                    .extension(row.getString("extension"))
                    .mimeType(row.getString("mimeType"))
                    .path(row.getString("path"))
                    .state(row.getString("state"))
                    .build();

    @Override
    public Optional<File> create(File file) {
        {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection
                        .prepareStatement(SQL_INSERT);
                statement.setString(1, file.getFileName());
                statement.setString(2, file.getUploadUser());
                statement.setLong(3, file.getSize());
                statement.setString(4, file.getPath());
                statement.setString(5, file.getState());
                statement.setString(6, file.getMimeType());
                statement.setString(7, file.getExtension());
                return statement;
            }, keyHolder);

            file.setId((Long) keyHolder.getKey());
        }
        return Optional.of(file);
    }

    @Override
    public Optional<File> read(String fileName) {
        try {
            File file = jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, new Object[]{fileName}, userRowMapper);
            return Optional.ofNullable(file);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void update(File file) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<File> getFileById(Integer id) {
        try {
            File file = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, userRowMapper);
            return Optional.ofNullable(file);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
