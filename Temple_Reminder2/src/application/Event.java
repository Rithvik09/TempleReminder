package application;
import java.util.*;
import java.io.*;
public class Event {
	private static String Name;
	private static String eventType;
	private Date date;
	private Date Edate;
	private Date Fdate;
	private String Category;
	private static String SubscriptionStatus;
	private static String Email;
	 int cy = 1;
	public Event(String n, String e, Date d, Date ed, String ss, String em) {
		Name = n;
		eventType = e;
		date = d;
		Edate = ed;
		SubscriptionStatus = ss;
		Email = em;
	}
	
	public Event(String n, String e, Date d, Date ed, Date fd, String c, String ss, String em) {
		Name = n;
		eventType = e;
		date = d;
		Edate = ed;
		Fdate = fd;
		Category = c;
		SubscriptionStatus = ss;
		Email = em;
	}

	public void setName(String n) {
		this.Name = n;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setEventType(String e) {
		this.eventType = e;
	}
	
	public String getEventType() {
		return eventType;
	}

	public void setDate(Date d) {
		this.date = d;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setEdate(Date ed) {
		this.Edate = ed;
	}
	
	public Date getEdate() {
		return Edate;
	}

	public void setFdate(Date fd) {
		int d = this.Edate.getDate();
		d = d - 10;
		int y = this.date.getYear();
		int m = this.Edate.getMonth();
		if(d < 10) {
			m = m - 1;
		}
		if(Category.equals("Monthly")) {
			m = m + 3;
		}else {
			y = y + cy;
		}
		fd = new Date(y, m, d);
		Fdate = fd;
	}
	
	public Date getFdate() {
		return Fdate;
	}
	
	public void setCategory(String c) {
		this.Category = c;
	}
	
	public String getCategory() {
		return Category;
	}
	
	public void setCY(int cy) {
		this.cy = cy;
	}
	
	public void setSubscriptionStatus(String ss) {
		this.SubscriptionStatus = ss;
	}
	
	public String getSubscriptionStatus() {
		return SubscriptionStatus;
	}
	
	public void setEmail(String em) {
		this.Email = em;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public static void main(String[] args) {
		if(SubscriptionStatus.equals("Yes")||SubscriptionStatus.equals("Y")) {
			Subscription s = new Subscription(Name, eventType, Email);
		}
	}
}
