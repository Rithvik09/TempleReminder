package application;
import java.util.*;
import java.io.*;
public class Birthday {
	private Date bDate;
	private String Name;
	private String Gothram;
	private String Nakshatram;
	private Date fDate;
	
	public Birthday(Date d, String n, String g, String na) {
		bDate = d;
		Name = n;
		Gothram = g;
		Nakshatram = na;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getName() {
		return Name;
	}
	public void setName(int name) {
		Name = name;
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
}
