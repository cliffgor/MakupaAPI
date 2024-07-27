package com.cliffgor.makupaapi.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String sendgridApiKey;

    @Value("${sendgrid.from-email}")
    private String fromEmail;

    public void  sendOTPEmail(String to, String otp) throws IOException {

        Email from = new Email(fromEmail);
        String subject = "Your OTP for Account Verification";
        Email toEmail = new Email(to);
        Content content = new Content("text/plain", "Your OTP is: " + otp + ". It will expire in 15 minutes.");
        Mail mail = new Mail(from, subject, toEmail, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);

        if (response.getStatusCode() != 202) {
            throw new IOException("Failed to send email. Status code: " + response.getStatusCode());
        }

    }

}
