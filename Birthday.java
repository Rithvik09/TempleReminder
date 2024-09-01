

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.*;
import java.text.SimpleDateFormat;
public class Birthday {
	private static Date bDate;
	private static String Name;
	private static String Email;
	private static String Gothram;
	private static String Nakshatram;
	private static Date fDate;
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
	
	public Birthday(Date d, String n, String e, String g, String na) {
		bDate = d;
		Name = n;
		Email = e;
		Gothram = g;
		Nakshatram = na;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGothram() {
		return Gothram;
	}
	public void setGothram(String gothram) {
		Gothram = gothram;
	}
	public String getNakshatram() {
		return Nakshatram;
	}
	public void setNakshatram(String nakshatram) {
		Nakshatram = nakshatram;
	}
	public void setFdate() {
		Date dateToday = new Date();
		int d = this.bDate.getDate();
		int y = dateToday.getYear();
		int m = this.bDate.getMonth();
		if(dateToday.getMonth() >= this.bDate.getMonth()) {
			if(dateToday.getDay() >= this.bDate.getDay()) {
				y++;
			}
		}
		fDate = new Date(y, m, d);
	}
	
	public Date getFdate() {
		return fDate;
	}
	
	public void changeFdate(Date fDate) {
		int y = fDate.getYear();
		y++;
		fDate.setYear(y);
	}
	public String toString() {
		return "Name: " + Name + "\n" + "Birthday: " + formatter.format(bDate) + "\n" + "Gothram: " + Gothram + "\n" + "Nakshatram: " + Nakshatram;	
	}
	public static void sendMail(String recipient) throws Exception{
//		System.out.println("Preparing to send ");
		Properties p = new Properties();
		
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		
		String myEmail = "sriram.srivaritemple@gmail.com";
		String password = "ybujzeldpgakusfk";
		
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
			m.setSubject("Blessings from SriVari SriBalaji Temple");
			m.setText("Dear Devotee,\n" + 
					"\n" + 
					"Our birthday wishes to " + Name + " in your family. \n" +
					"\n" + 
					"We’ll perform Archana to Thayaar and Perumal on their behalf and pray to "
					+ "\n" + "SriVari Sri Balaji to bring happiness, health and wealth to " + Name + "." + "\n" +
					"\n" + 
					"Our temple has no ticketing system and we encourage devotees to make donations on “Yatha Sakthi” basis. "
					+ "\n" + "We appreciate all your contributions. \n" + 
					"\n" + 
					"You can use the link below for your donations:\n" + 
					"\n" + 
					"<link will be included here>\n" + 
					"\n" + 
					"- Temple Admin");
			return m;
		}catch(Exception e) {
			Logger.getLogger(JavaMailUtilBirthday.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
