import java.util.*;
import java.io.*;
public class Event {
	private static String Name;
	private static String eventType;
	private static Date date;
	private static Date Edate;
	private static Date Fdate;
	static int cy = 1;
	static int cm = 1;
	public Event(String n, String e, Date d, Date ed) {
		Name = n;
		eventType = e;
		date = d;
		Edate = ed;
	}
	
	public Event(String n, String e, Date d, Date ed, Date fd) {
		Name = n;
		eventType = e;
		date = d;
		Edate = ed;
		Fdate = fd;
	}

	public static void setName(String n) {
		Event.Name = n;
	}
	
	public static String getName() {
		return Name;
	}
	
	public static void setEventType(String e) {
		Event.eventType = e;
	}
	
	public static String getEventType() {
		return eventType;
	}

	public static void setDate(Date d) {
		Event.date = d;
	}
	
	public static Date getDate() {
		return date;
	}
	
	public static void setEdate(Date ed) {
		Event.Edate = ed;
	}
	
	public static Date getEdate() {
		return Edate;
	}

	public static void setFdate(Date fd) {
		int d = Edate.getDate();
		d = d - 10;
		int y = date.getYear();
		int m = Edate.getMonth() - 1;
		if(Name.equals("Shreemandam")) {
			m = m + cm;
		}else {
			y = y + cy;
		}
		fd = new Date(y, m, d);
		Fdate = fd;
	}
	
	public static Date getFdate() {
		return Fdate;
	}
	
	public static void setCY(int cy) {
		cy++;
	}
	
	public static void setCM(int cm) {
		cm++;
	}
}
