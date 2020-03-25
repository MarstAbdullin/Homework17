package homework17.services;

import homework17.models.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface FileSaver {
    void saveFile(MultipartFile file, String storageName);
}
