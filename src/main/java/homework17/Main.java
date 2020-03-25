package homework17;

import homework17.services.TemplateProcessor;
import homework17.services.TemplateProcessorImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TemplateProcessor templateProcessor = new TemplateProcessorImpl();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("photoUrl", "localhost:8080/files");
        System.out.println(templateProcessor.processTemplate("ftl/email.ftl", parameters));
    }
}
