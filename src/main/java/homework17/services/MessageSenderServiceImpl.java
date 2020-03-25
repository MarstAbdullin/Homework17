package homework17.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Component
public class MessageSenderServiceImpl implements MessageSenderService{
    @Autowired
    JavaMailSender emailSender;

    public void sendMessage(String email, String message) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(email);
            helper.setText(message, true);
            helper.setSubject("Test send HTML email");
            emailSender.send(mimeMessage);
        } catch (javax.mail.MessagingException e) {
            System.out.println(e.getMessage());
            System.out.println("Can not create MimeMessage");
        }
    }
}
