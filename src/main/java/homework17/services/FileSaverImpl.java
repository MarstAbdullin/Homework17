package homework17.services;

import homework17.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


@Component
public class FileSaverImpl implements FileSaver {

    public void saveFile(MultipartFile file, String fileName) {
        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf("."));
        try {
            file.transferTo(new File("D:\\JavaLab15\\Homework17\\src\\main\\resources\\files", fileName + extension));
        } catch (IOException e) {
            System.out.println("Can not reach path to file storage");
            throw new IllegalArgumentException(e);
        }
    }
}
