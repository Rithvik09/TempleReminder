
import java.io.*; 
import java.util.*;
public class Reminder {
    static ArrayList<Event> events = new ArrayList<Event>();
	public static void main(String[] args){
		Date d = new Date();
		Date ed = new Date(2020,00,23);
		Event e = new Event("Sriram", "Marriage", d, ed, "Y", "sriramvenk@hotmail.com");
		addEvent(e, d);
		System.out.println(e.getFdate());
	} 
	public static void addEvent(Event e, Date d) {
		events.add(e);
		e.setFdate(d);
	}
	public void removeEvent(Event e) {
		events.remove(e);
	}
	public ArrayList<Event> compare() {
		Date e1 = new Date();
		ArrayList<Event> results = new ArrayList<Event>();
		for(int i = 0; i < events.size(); i ++) {
			if(e1 == events.get(i).getFdate()) {
				results.add(events.get(i));
			}
		}
		return results;
	}
}
