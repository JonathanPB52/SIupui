/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jonhy
 */
public class envioCorreo {
    
    public void enviarCorreo(String destinatario, String asunto){
        
         final String username = "unidosporunaidea@gmail.com";
            final String password = "sistema1234";
            Properties properties = new Properties();

            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("aa@aa.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                message.setSubject("UPUI-Unidos-Por-Una-Idea");
                
                BodyPart parteTexto= new MimeBodyPart();
                parteTexto.setContent("UPUI<b>te damos la bienvenida a nuestro sistema.<b>","text/html");
    
                message.setText(asunto);
                Transport.send(message);
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            }
        
    }
    
}
