package homework17.services;

import homework17.models.File;
import homework17.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Component
public class FileServiceImpl implements FileService{

    @Autowired
    FileRepository fileRepository;
    @Autowired
    private FileSaver fileSaver;

    public Optional<File> getCurrentFile(String fileName) {
        if (fileRepository.read(fileName).isPresent())
            return Optional.empty();
        else
            return fileRepository.read(fileName);
    }

    public void saveFile(MultipartFile file, String email, String fileName) {
        fileSaver.saveFile(file, fileName);
        fileRepository.create(File.builder()
                .fileName(fileName)
                .state("Normalnoe")
                .size(file.getSize())
                .path("D:\\JavaLab15\\Homework17\\src\\main\\resources\\files" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")))
                .mimeType(file.getContentType())
                .extension(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")))
                .uploadUser(email)
                .build());
    }
}
