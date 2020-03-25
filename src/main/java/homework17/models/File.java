package homework17.models;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class File {
    private Long id;//
    private String fileName;//
    private String uploadUser;//
    private Long size;//
    private String path;//
    private String state;
    private String mimeType;//
    private String extension;//

    public File(String fileName, String uploadUser, Long size, String path, String state, String mimeType, String extension) {
        this.fileName = fileName;
        this.uploadUser = uploadUser;
        this.size = size;
        this.path = path;
        this.state = state;
        this.mimeType = mimeType;
        this.extension = extension;
    }
}
