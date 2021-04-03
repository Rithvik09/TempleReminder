import java.util.*;
import java.io.*;
public class Event {
	private static String Name;
	private static String eventType;
	private static Date date;
	public Event(String n, Date d) {
		Name = n;
		date = d;
	}

	public static void setName(String n) {
		Event.Name = n;
	}
	
	public static String getName() {
		return Name;
	}

	public static void setDate(Date d) {
		Event.date = d;
	}
	
	public static Date getDate() {
		return date;
	}
}
