package application;

import java.util.*;
import java.io.*;
public class BirthdayEmail {
	static ArrayList<Birthday> birthdays = new ArrayList<Birthday>();
	public static void main(String[] args){
		Date d = new Date();
		Date ed = new Date(d.getYear(),03,14);
		Birthday b = new Birthday(ed, "Sriram", "Coudanya", "Jestha");
		addBirthday(b, d);
		System.out.println(b.getFdate());
	} 
	public static void addBirthday(Birthday b, Date d) {
		birthdays.add(b);
		b.setFdate();
	}
	public ArrayList<Birthday> compare() {
		Date e1 = new Date();
		ArrayList<Birthday> results = new ArrayList<Birthday>();
		for(int i = 0; i < birthdays.size(); i ++) {
			if(e1 == birthdays.get(i).getFdate()) {
				results.add(birthdays.get(i));
				birthdays.get(i).setFdate();
			}
		}
		return results;
	}
}
