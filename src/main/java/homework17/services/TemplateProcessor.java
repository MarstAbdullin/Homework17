package homework17.services;

import java.util.Map;

public interface TemplateProcessor {
    String processTemplate(String template, Map<String, Object> parameters);
}
