import java.util.*; 
import java.io.*;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Email_Birthday_and_Marriage {
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
	public static void main(String[] args) throws Exception{
		File excelFile = new File("/Users/2kAccount/eclipse-workspace/Temple_Reminder/Contact Information (Responses) (1) 2.xlsx");
	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    
	    Iterator<Row> rowIt = sheet.iterator();
	    DataFormatter df = new DataFormatter();
	    int count = 1;
	    while(rowIt.hasNext()) {
	      Row row = rowIt.next();
	      if(count != 1) {
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
	    	  if(!arr.get(6).equals("null")) {
	    		  Date md = new Date();
	    		  if(arr.get(6).length() < 6) {
		    		  md = new Date(dateToday.getYear(), Integer.parseInt(arr.get(6).substring(0, arr.get(6).indexOf("/"))) - 1, Integer.parseInt(arr.get(6).substring(arr.get(6).indexOf("/") + 1)));
	    		  }else {
	    			  String h = arr.get(6).substring(arr.get(6).indexOf("/") + 1);
	    			  md = new Date(dateToday.getYear(), Integer.parseInt(arr.get(6).substring(0, arr.get(6).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
	    		  }
	    		  Marriage m = new Marriage(md, arr.get(8), arr.get(9), arr.get(2), arr.get(7), arr.get(10), arr.get(11));
	    		  if(m.getMdate().getMonth() == dateToday.getMonth() && m.getMdate().getDay() == dateToday.getDay()) {
	    			  Marriage.sendMail(m.getEmail());
	    			  System.out.println("MEmail sent " + " to " + m.getEmail());
	    		  }
	    	  }
    		  if(arr.get(13).equals("Yes")) {
    			  Date bd1 = new Date();
    	    	  if(arr.get(14).length() < 6) {
    	    		  bd1 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(14).substring(0, arr.get(14).indexOf("/"))) - 1, Integer.parseInt(arr.get(14).substring(arr.get(14).indexOf("/") + 1)));
    	    	  }else {
    	    		  String h = arr.get(14).substring(arr.get(14).indexOf("/") + 1);
    	    		  bd1 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(14).substring(0, arr.get(14).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
    	    	  }
        		  Birthday b1 = new Birthday(bd1, arr.get(15), arr.get(2), arr.get(16), arr.get(17));
        		  if(b1.getbDate().getMonth() == dateToday.getMonth() && b1.getbDate().getDay() == dateToday.getDay()) {
      				Birthday.sendMail(b1.getEmail());
      				System.out.println("BEmail sent " + " to " + b1.getEmail());
        		  }
        		  if(arr.get(18).equals("Yes")) {
        			  Date bd2 = new Date();
        	    	  if(arr.get(19).length() < 6) {
        	    		  bd2 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(19).substring(0, arr.get(19).indexOf("/"))) - 1, Integer.parseInt(arr.get(19).substring(arr.get(19).indexOf("/") + 1)));
        	    	  }else {
        	    		  String h = arr.get(19).substring(arr.get(19).indexOf("/") + 1);
        	    		  bd2 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(19).substring(0, arr.get(19).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
        	    	  }
            		  Birthday b2 = new Birthday(bd2, arr.get(20), arr.get(2), arr.get(21), arr.get(22));
            		  if(b2.getbDate().getMonth() == dateToday.getMonth() && b2.getbDate().getDay() == dateToday.getDay()) {
          				Birthday.sendMail(b2.getEmail());
          				System.out.println("BEmail sent " + " to " + b2.getEmail());
            		  }
            		  if(arr.get(23).equals("Yes")) {
            			  Date bd3 = new Date();
            	    	  if(arr.get(24).length() < 6) {
            	    		  bd3 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(24).substring(0, arr.get(24).indexOf("/"))) - 1, Integer.parseInt(arr.get(24).substring(arr.get(24).indexOf("/") + 1)));
            	    	  }else {
            	    		  String h = arr.get(24).substring(arr.get(24).indexOf("/") + 1);
            	    		  bd3 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(24).substring(0, arr.get(24).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
            	    	  }
                		  Birthday b3 = new Birthday(bd3, arr.get(25), arr.get(2), arr.get(26), arr.get(27));
                		  if(b3.getbDate().getMonth() == dateToday.getMonth() && b3.getbDate().getDay() == dateToday.getDay()) {
              				Birthday.sendMail(b3.getEmail());
              				System.out.println("BEmail sent " + " to " + b3.getEmail());
                		  }
                		  if(arr.get(27).equals("Yes")) {
                			  Date bd4 = new Date();
                	    	  if(arr.get(28).length() < 6) {
                	    		  System.out.println(arr.get(28).indexOf("/"));
                	    		  bd4 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(28).substring(0, arr.get(28).indexOf("/"))) - 1, Integer.parseInt(arr.get(28).substring(arr.get(28).indexOf("/") + 1)));
                	    	  }else {
                	    		  String h = arr.get(28).substring(arr.get(28).indexOf("/") + 1);
                	    		  bd4 = new Date(dateToday.getYear(), Integer.parseInt(arr.get(28).substring(0, arr.get(28).indexOf("/"))) - 1, Integer.parseInt(h.substring(0, h.indexOf("/"))));
                	    	  }
                    		  Birthday b4 = new Birthday(bd4, arr.get(30), arr.get(2), arr.get(31), arr.get(32));
                    		  if(b4.getbDate().getMonth() == dateToday.getMonth() && b4.getbDate().getDay() == dateToday.getDay()) {
                    				Birthday.sendMail(b4.getEmail());
                    				System.out.println("BEmail sent " + " to " + b4.getEmail());
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
	} 
}
