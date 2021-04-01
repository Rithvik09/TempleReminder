package application;
import java.util.*; 
import java.io.*;
public class Main{
	static int cy = 1;
	Date d = new Date();
	private static ArrayList<Event> events = new ArrayList<Event>();
	
	public static void main(String[] args) {
		compare();
	}
	
	public static void addEvent(Event e) {
		events.add(e);
		e.setFdate(e.getDate());
	}
	
	public static void compare() {
		Date e1 = new Date();
		for(int i = 0; i < events.size(); i ++) {
			int j = e1.compareTo(events.get(i).getFdate());
			if(j == 0) {
				if(events.get(i).getName().equals("Shreemandam")) {
					
				} else {
					events.get(i).setCY(cy);
					cy++;
				}
			}
		}
	}
}
