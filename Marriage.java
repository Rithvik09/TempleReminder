


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
	
public class Marriage {
	private static Date Mdate;
	private static String HName;
	private static String HNakshatram;
	private static String Email;
	private static String Gothram;
	private static String WName;
	private static String WNakshatram;
	private static Date fDate;
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
	
	public Marriage(Date d, String hn, String hna, String e, String g, String wn, String wna) {
		Mdate = d;
		HName = hn;
		HNakshatram = hna;
		Email = e;
		Gothram = g;
		WName = wn;
		WNakshatram = wna;
	}

	public static String getHName() {
		return HName;
	}

	public static void setHName(String hName) {
		HName = hName;
	}

	public static String getHNakshatram() {
		return HNakshatram;
	}

	public static void setHNakshatram(String hNakshatram) {
		HNakshatram = hNakshatram;
	}

	public static String getWName() {
		return WName;
	}

	public static void setWName(String wName) {
		WName = wName;
	}

	public static String getWNakshatram() {
		return WNakshatram;
	}

	public static void setWNakshatram(String wNakshatram) {
		WNakshatram = wNakshatram;
	}

	public Date getMdate() {
		return Mdate;
	}

	public void setMdate(Date mdate) {
		Mdate = mdate;
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

	public Date getfDate() {
		return fDate;
	}

	public void setfDate() {
		Date dateToday = new Date();
		int d = this.Mdate.getDate();
		int y = dateToday.getYear();
		int m = this.Mdate.getMonth();
		if(dateToday.getMonth() >= this.Mdate.getMonth()) {
			if(dateToday.getDay() >= this.Mdate.getDay()) {
				y++;
			}
		}
		fDate = new Date(y, m, d);
	}
	
	public void changeFdate(Date fDate) {
		int y = fDate.getYear();
		y++;
		fDate.setYear(y);
	}
	public String toString() {
		return "Husband's Name: " + HName + "\n" + "Wife's Name: " + WName + "\n" + "Marriage Aniversary: " + formatter.format(Mdate) + "\n" + "Family Gothram: " + Gothram + "\n" + "Husband's Nakshatram: " + HNakshatram + "\n" + "Wife's Nakshatram: " + WNakshatram;
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
					"Happy Wedding Anniversary!\n" + 
					"\n" + 
					"We’ll perform Archana and pray to Thayaar and Perumal on your behalf to"
					+ "\n" + "bring happiness, health and wealth to all the members of your family.\n" + 
					"\n" + 
					"Our temple has no ticketing system and we encourage devotees to make donations on “Yatha Sakthi” basis. "
					+ "\n" + "We appreciate all your contributions. \n" +
					"\n" + 
					"You can use the link below for your donations:\n" + 
					"\n" + 
					"<link will be included here>\n" + 
					"\n" + 
					"- Temple Admin ");
			return m;
		}catch(Exception e) {
			Logger.getLogger(JavaMailUtilBirthday.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
