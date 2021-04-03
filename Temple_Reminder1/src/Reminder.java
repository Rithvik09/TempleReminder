import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String question = scan.nextLine();
		Date d = new Date();
		Event Ekadesi7 = new Event("Ekadesi", new Date(d.getYear(), 03, 07));
		Event Ekadesi8 = new Event("Ekadesi", new Date(d.getYear(), 03, 23));
		Event Ekadesi9 = new Event("Ekadesi", new Date(d.getYear(), 04, 06));
		Event Ekadesi10 = new Event("Ekadesi", new Date(d.getYear(), 04, 22));
		Event Ekadesi11 = new Event("Ekadesi", new Date(d.getYear(), 05, 05));
		Event Ekadesi12 = new Event("Ekadesi", new Date(d.getYear(), 05, 20));
		Event Ekadesi13 = new Event("Ekadesi", new Date(d.getYear(), 06, 05));
		Event Ekadesi14 = new Event("Ekadesi", new Date(d.getYear(), 06, 20));
		Event Ekadesi15 = new Event("Ekadesi", new Date(d.getYear(), 07, 04));
		Event Ekadesi16 = new Event("Ekadesi", new Date(d.getYear(), 07, 18));
		Event Ekadesi17 = new Event("Ekadesi", new Date(d.getYear(), 8, 02));
		Event Ekadesi18 = new Event("Ekadesi", new Date(d.getYear(), 8, 16));
		Event Ekadesi19 = new Event("Ekadesi", new Date(d.getYear(), 9, 02));
		Event Ekadesi20 = new Event("Ekadesi", new Date(d.getYear(), 9, 16));
		Event Ekadesi21 = new Event("Ekadesi", new Date(d.getYear(), 10, 02));
		Event Ekadesi22 = new Event("Ekadesi", new Date(d.getYear(), 10, 16));
		Event Ekadesi23 = new Event("Ekadesi", new Date(d.getYear(), 11, 14));
		System.out.println(Ekadesi23.getDate());
		Event Ekadesi24 = new Event("Ekadesi", new Date(d.getYear(), 11, 29));
		Event[] arr = {Ekadesi7, Ekadesi8, Ekadesi9, Ekadesi10, Ekadesi11, Ekadesi12, Ekadesi13, Ekadesi14, Ekadesi15,
				Ekadesi16, Ekadesi17, Ekadesi18, Ekadesi19, Ekadesi20, Ekadesi21, Ekadesi22, Ekadesi23, Ekadesi24};
		System.out.println(Arrays.toString(arr));
		if(question.contains("next")) {
			if(question.contains("Ekadesi")) {
				int month = 0;
				int date = 0;
				int i1 = 0;
				boolean b1 = false;
				while(b1 != true|| i1 < arr.length - 1) {
					if(d.getMonth() != arr[i1].getDate().getMonth()) {
						i1++;
					}else {
						month = d.getMonth();
						b1 = true;
					}
				}
				int i2 = 0;
				boolean b2 = false;
				while(b2 != true || i2 < arr.length) {
					if(month != arr[i2].getDate().getMonth()) {
						i2++;
					}else {
						if(d.getDate() < arr[i2].getDate().getDate()){
							date = arr[i2].getDate().getDate();
							b2 = true;
						}else {
							i2++;
						}
					}
				}
				String wmonth = "January";
				if(month == 01) {
					wmonth = "January";
				}else if (month == 02) {
					wmonth = "February";
				}else if (month == 03) {
					wmonth = "March";
				}else if (month == 04) {
					wmonth = "April";
				}else if (month == 05) {
					wmonth = "May";
				}else if (month == 06) {
					wmonth = "June";
				}else if (month == 07) {
					wmonth = "July";
				}else if (month == 8) {
					wmonth = "August";
				}else if (month == 9) {
					wmonth = "September";
				}else if (month == 10) {
					wmonth = "October";
				}else if (month == 11) {
					wmonth = "November";
				}else if (month == 12) {
					wmonth = "December";
				}
				
				String wday = "First";
				if(date == 01) {
					wday = "First";
				}else if (date == 02) {
					wday = "Second";
				}else if (date == 03) {
					wday = "Third";
				}else if (date == 04) {
					wday = "Fourth";
				}else if (date == 05) {
					wday = "Fifth";
				}else if (date == 06) {
					wday = "Sixth";
				}else if (date == 07) {
					wday = "Seventh";
				}else if (date == 8) {
					wday = "Eigth";
				}else if (date == 9) {
					wday = "Ninth";
				}else if (date == 10) {
					wday = "Tenth";
				}else if (date == 11) {
					wday = "Eleventh";
				}else if (date == 12) {
					wday = "Twelvth";
				}else if (date == 13) {
					wday = "Thirteenth";
				}else if (date == 14) {
					wday = "Fourteenth";
				}else if (date == 15) {
					wday = "Fifteenth";
				}else if (date == 16) {
					wday = "Sixteenth";
				}else if (date == 17) {
					wday = "Seventeenth";
				}else if (date == 18) {
					wday = "Eighteenth";
				}else if (date == 19) {
					wday = "Nineteenth";
				}else if (date == 20) {
					wday = "Twentieth";
				}else if (date == 31) {
					wday = "TwentyFirst";
				}else if (date == 21) {
					wday = "TwentySecond";
				}else if (date == 22) {
					wday = "TwentyThird";
				}else if (date == 23) {
					wday = "TwentyFourth";
				}else if (date == 24) {
					wday = "TwentyFifth";
				}else if (date == 25) {
					wday = "TwentySixth";
				}else if (date == 26) {
					wday = "TwentySeventh";
				}else if (date == 27) {
					wday = "TwentyEigth";
				}else if (date == 28) {
					wday = "TwentyNinth";
				}else if (date == 29) {
					wday = "Thritieth";
				}else if (date == 30) {
					wday = "ThirtyFirst";
				}
				
				System.out.println("The next Ekadesi is on " + wmonth + " " + wday);
			}
		}
	}
}
