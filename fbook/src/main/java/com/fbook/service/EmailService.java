package com.fbook.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service("iEmailService")
public class EmailService implements IEmailService{

	public void Mail(String mailId,String userName){
        try{
       
        String result;
        
        final String to = mailId;

        final String subject = "Welcome to Facebook N";
        
        String messg = " Dear "+userName+", <br/><br/> <i>Warm Greetings from NIIT FaceBook!!</i> ";
        String msg="Hi Welcome to Facebook !!<br/><br/>Warm Regards<br/> NIIT Job Portal Team. ";
        messg=messg.concat(msg);
        
        // Sender's email ID and password needs to be mentioned
        final String from = "MailId@mail.com";
        final String pass = "XXXXXXXXX";

        // Defining the gmail host
        String host = "smtp.gmail.com";

        // Creating Properties object
        Properties props = new Properties();

            // Defining properties
            props.put("mail.smtp.host", host);
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.user", from);
            props.put("mail.password", pass);
            props.put("mail.port", "465");

        // Authorized the Session object.
        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, pass);
        }
    });

            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(mailSession);
                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));
                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to));
                message.addRecipient(Message.RecipientType.BCC,
                        new InternetAddress("maheshwari.niithabsiguda@gmail.com"));
                // Set Subject: header field
                message.setSubject(subject);
                // Now set the actual message
                message.setContent(messg, "text/html; charset=utf-8");
                // Send message
                Transport.send(message);
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                    result = "Error: unable to send mail....";
                }
            }
            catch(Exception e)
            {}
}
}
