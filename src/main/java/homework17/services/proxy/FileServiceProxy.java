package homework17.services.proxy;

import homework17.aspects.AfterSaveAdvice;
import homework17.models.File;
import homework17.services.FileService;
import homework17.services.FileServiceImpl;
import homework17.services.TemplateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Optional;

@Service
public class FileServiceProxy implements FileService {

    @Autowired
    TemplateProcessor templateProcessor;
    @Qualifier("fileServiceImpl")
    @Autowired
    FileServiceImpl target;
    @Autowired
    AfterSaveAdvice afterSaveAdvice;

    @Override
    public void saveFile(MultipartFile file, String email, String storageName) {
        target.saveFile(file, email, storageName);
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("photoUrl", storageName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        afterSaveAdvice.after(email, templateProcessor.processTemplate("ftl/email.ftl", parameters));
    }

    @Override
    public Optional<File> getCurrentFile(String fileName) {
        return target.getCurrentFile(fileName);
    }
}
