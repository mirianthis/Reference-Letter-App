package gr.hua.dit.referenceLetterApp.service;

import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    SendGrid sendGrid;

    public void sendEmail(String email){
        Mail mail = prepareMail(email);
    }

    public Mail prepareMail(String email){

        Mail mail = new Mail();

        Email fromEmail = new Email();

        fromEmail.setEmail("");
        Email to = new Email();
        to.setEmail(email);

        Personalization personalization = new Personalization();
        personalization.addTo(to);

        return null;
    }
}
