

import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class JavaMailUtilBirthday {
	public static void sendMail(String recipient) throws Exception{
//		System.out.println("Preparing to send ");
		Properties p = new Properties();
		
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		
		String myEmail = "sriram.srivaritemple@gmail.com";
		String password = "SriVariOnl1ne";
		
		Session s = Session.getInstance(p, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, password);
			}
		});
		Message m = prepareMessage(s, myEmail, recipient);
		
		Transport.send(m);
//		System.out.println("Message sent successfully");
	}
	
	private static Message prepareMessage(Session s, String myEmail, String recipient) {
		try{
			Message m = new MimeMessage(s);
			m.setFrom(new InternetAddress(myEmail));
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			m.setSubject("My First Email from Java App");
			m.setText("Hey There, \n Happy Birthday!");
			return m;
		}catch(Exception e) {
			Logger.getLogger(JavaMailUtilBirthday.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
