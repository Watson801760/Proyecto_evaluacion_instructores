/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author user
 */
public class PropiedadesCorreo {
    public static void enviarCorreo (String host,String puerto, final String usuario,
                                     final String clave, String direcion,String asunto,String mensaje) throws AddressException, MessagingException{
        Properties propiedades = new Properties();
        propiedades.put("mail.transport.protocol", "smtp");
        propiedades.put("mail.smtp.host",host);
        propiedades.put("mail.smtp.port",puerto);
        propiedades.put("mail.smtp.timeout", "50000" );
        propiedades.put("mail.smtp.connecttimeout", "5000");
        propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedades.put("mail.smtp.starttls.enable", "true");
        
        Authenticator autenticar = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(usuario, clave);
            }
        };
        
        Session sesion = Session.getInstance(propiedades,autenticar);
        
        Message msg = new MimeMessage(sesion);
        msg.setFrom(new InternetAddress(usuario));
        InternetAddress[] direciones = {new InternetAddress(direcion)};
        msg.setRecipients(Message.RecipientType.TO, direciones);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setText(mensaje);
        Transport.send(msg);
    }
}
