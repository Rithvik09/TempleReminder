

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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jar.Birthday;
import jar.Marriage;
public class Email1 {
//	private static ArrayList<Birthday> birthdays = new ArrayList<Birthday>();
//	private static ArrayList<Marriage> marriages = new ArrayList<Marriage>();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
	public static void main(String[] args) throws Exception{
		File excelFile = new File("/Users/2kAccount/eclipse-workspace/Temple_Reminder/Contact Information (Responses) (1).xlsx");
	    FileInputStream fis = new FileInputStream(excelFile);
	    // we create an XSSF Workbook object for our XLSX Excel File
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    // we get first sheet
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    
	    // we iterate on rows
	    Iterator<Row> rowIt = sheet.iterator();
	    DataFormatter df = new DataFormatter();
	    int count = 1;
	    while(rowIt.hasNext()) {
	      Row row = rowIt.next();
	      if(count != 1) {
	    	  // iterate on cells for the current row
	    	  Iterator<Cell> cellIterator = row.cellIterator();
	    	  ArrayList<String> arr = new ArrayList<String>();
	    	  int c = sheet.getRow(0).getLastCellNum();
	    	  for(int i = 0; i < c; i++) {
	    		  Cell cell = row.getCell(i);
	    		  if(cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
	    			  arr.add("null");
	    		  }else {
	    			  arr.add(cell.toString());
	    		  }
	    	  }
	    	  Date dateToday = new Date();
	    	  Date md = new Date();
	    	  if(arr.get(5).length() < 5) {
	    		  md = new Date(dateToday.getYear(), Integer.parseInt(arr.get(5).substring(0, arr.get(5).indexOf("/"))) - 1, Integer.parseInt(arr.get(5).substring(arr.get(5).indexOf("/") + 1)));
	    	  }else {
	    		  String h = arr.get(5).substring(arr.get(5).indexOf("/") + 1);
	    		  md = new Date(dateToday.getYear(), Integer.parseInt(arr.get(5).substring(0, arr.get(5).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
	    	  }
	    	  Marriage m = new Marriage(md, arr.get(7), arr.get(8), arr.get(2), arr.get(6), arr.get(9), arr.get(10));
    		  if(m.getMdate().getMonth() == dateToday.getMonth() && m.getMdate().getDay() == dateToday.getDay()) {
  				Marriage.sendMail(m.getEmail());
  				System.out.println("MEmail sent " + " to " + m.getEmail());
  			  }
    		  if(arr.get(12).equals("Yes")) {
    			  Date bd1 = new Date();
    	    	  if(arr.get(13).length() < 5) {
    	    		  bd1 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(13).substring(0, arr.get(13).indexOf("/"))) - 1, Integer.parseInt(arr.get(13).substring(arr.get(13).indexOf("/") + 1)));
    	    	  }else {
    	    		  String h = arr.get(13).substring(arr.get(13).indexOf("/") + 1);
    	    		  bd1 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(13).substring(0, arr.get(13).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
    	    	  }
        		  Birthday b1 = new Birthday(bd1, arr.get(14), arr.get(2), arr.get(15), arr.get(16));
        		  if(b1.getbDate().getMonth() == dateToday.getMonth() && b1.getbDate().getDay() == dateToday.getDay()) {
      				Birthday.sendMail(b1.getEmail());
      				System.out.println("MEmail sent " + " to " + m.getEmail());
        		  }
        		  if(arr.get(17).equals("Yes")) {
        			  Date bd2 = new Date();
        	    	  if(arr.get(18).length() < 5) {
        	    		  bd2 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(18).substring(0, arr.get(18).indexOf("/"))) - 1, Integer.parseInt(arr.get(18).substring(arr.get(18).indexOf("/") + 1)));
        	    	  }else {
        	    		  String h = arr.get(18).substring(arr.get(18).indexOf("/") + 1);
        	    		  bd2 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(18).substring(0, arr.get(18).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
        	    	  }
            		  Birthday b2 = new Birthday(bd2, arr.get(19), arr.get(2), arr.get(20), arr.get(21));
            		  if(b2.getbDate().getMonth() == dateToday.getMonth() && b2.getbDate().getDay() == dateToday.getDay()) {
          				Birthday.sendMail(b2.getEmail());
          				System.out.println("MEmail sent " + " to " + m.getEmail());
            		  }
            		  if(arr.get(22).equals("Yes")) {
            			  Date bd3 = new Date();
            	    	  if(arr.get(23).length() < 5) {
            	    		  bd3 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(23).substring(0, arr.get(23).indexOf("/"))) - 1, Integer.parseInt(arr.get(23).substring(arr.get(23).indexOf("/") + 1)));
            	    	  }else {
            	    		  String h = arr.get(23).substring(arr.get(23).indexOf("/") + 1);
            	    		  bd3 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(23).substring(0, arr.get(23).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
            	    	  }
                		  Birthday b3 = new Birthday(bd3, arr.get(24), arr.get(2), arr.get(25), arr.get(26));
                		  if(b3.getbDate().getMonth() == dateToday.getMonth() && b3.getbDate().getDay() == dateToday.getDay()) {
              				Birthday.sendMail(b3.getEmail());
              				System.out.println("MEmail sent " + " to " + m.getEmail());
                		  }
                		  if(arr.get(27).equals("Yes")) {
                			  Date bd4 = new Date();
                	    	  if(arr.get(28).length() < 5) {
                	    		  bd4 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(28).substring(0, arr.get(28).indexOf("/"))) - 1, Integer.parseInt(arr.get(28).substring(arr.get(28).indexOf("/") + 1)));
                	    	  }else {
                	    		  String h = arr.get(28).substring(arr.get(28).indexOf("/") + 1);
                	    		  bd4 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(28).substring(0, arr.get(28).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
                	    	  }
                    		  Birthday b4 = new Birthday(bd4, arr.get(29), arr.get(2), arr.get(30), arr.get(31));
                    		  if(b4.getbDate().getMonth() == dateToday.getMonth() && b4.getbDate().getDay() == dateToday.getDay()) {
                    				Birthday.sendMail(b4.getEmail());
                    				System.out.println("MEmail sent " + " to " + m.getEmail());
                    		  }
                		  }
            		  }
        		  }
    		  }
	      }else {
	    	count++;
	    }
	    
	    workbook.close();
	    fis.close();
	   }
//		compareBirthdays();
//		compareMarriages();
	} 
//	public static void addBirthday(Birthday b) {
//		birthdays.add(b);
//		b.setFdate();
//	}
//	public static void addMarriage(Marriage m) {
//		marriages.add(m);
//		m.setfDate();
//	}
//	public static void compareBirthdays() throws Exception {
//		Date e1 = new Date();
//		for(int i = 0; i < birthdays.size(); i++) {
//			if(birthdays.get(i).getbDate().getMonth() == e1.getMonth() && birthdays.get(i).getbDate().getDay() == e1.getDay()) {
////				Birthday.sendMail(birthdays.get(i).getEmail());
////				birthdays.get(i).changeFdate(birthdays.get(i).getFdate());
//				System.out.println("BEmail sent " + i + " times to " + birthdays.get(i).getEmail());
//			}
//		}
//	}
//	public static void compareMarriages() throws Exception {
//		Date e1 = new Date();
//		for(int i = 0; i < marriages.size(); i++) {
//			System.out.println(marriages.get(i).getMdate());
//			if(marriages.get(i).getMdate().getMonth() == e1.getMonth() && marriages.get(i).getMdate().getDay() == e1.getDay()) {
//				JavaMailUtilMarriage.sendMail(marriages.get(i).getEmail());
//				marriages.get(i).changeFdate(marriages.get(i).getMdate());
//				System.out.println("MEmail sent " + i + " times to " + marriages.get(i).getEmail());
//			}
//		}
//	}
}
