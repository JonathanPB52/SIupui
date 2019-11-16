package NuevosControllers;

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
import entidades.Usuario;
import entidades.Beneficiado;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Jonhy
 */

@Named(value = "controladorCorreoMasivo")
@SessionScoped

public class ControladorCorreoMasivo implements Serializable{
    
    Usuario usuario = new Usuario();
    Beneficiado benf= new Beneficiado();
    String destinatario;
    String asunto = "Hola";
    
    public void enviarCorreoUSUARISO(){
        
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
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getCorreo()));
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
