package homework17.aspects;

import homework17.services.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfterSaveAdviceImpl implements AfterSaveAdvice{

    @Autowired
    MessageSenderService messageSenderService;

    @Override
    public void after(String email, String message) {
        messageSenderService.sendMessage(email, message);
    }
}
