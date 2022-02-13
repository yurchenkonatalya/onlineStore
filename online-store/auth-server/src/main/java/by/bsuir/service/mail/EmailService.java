package by.bsuir.service.mail;

import by.bsuir.exception.EmailSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String sender;

    Map<String, String> nonActiveEmails;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine){
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        nonActiveEmails = new HashMap<>();
    }

    public void sendActivationKey(Mail mail){
        ActivationMail activationMail = (ActivationMail) mail;
        sendHtml(activationMail);
        nonActiveEmails.put(activationMail.getKey(), mail.getReceiver());
    }

    public void sendHtml(Mail mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariables(mail.getContext());

            String emailContent = templateEngine.process(mail.getLocation(), context);

            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setTo(mail.getReceiver());
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setText(emailContent, true);
            javaMailSender.send(message);
        }catch (MessagingException e){
            throw new EmailSendException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
