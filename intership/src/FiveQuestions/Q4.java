package FiveQuestions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/*
 * 
 *   
4) Create DateManipulator class to convert String to date, date to String and to find out number
 of days between two dates.

*
*    public static Date stringToDate(String str) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    // Convert Date to String
    public static String dateToString(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

*/
class DateManipulator {
	 public void stringToDate(String date) throws Exception {

         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         Date date1 = sdf.parse(date);
         System.out.println("Converted String to Date: " + date1);
		 
	 }
	 public void dateToString(Date date) {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         String date1 = sdf.format(date);
         System.out.println("Converted Date to String "+date1);
	 }
	 public void dateDiff(Date date1,Date date2) {
		 System.out.println("Difference Between " +date1 +" And "+date2);
		 long diff = (date2.getTime() - date1.getTime())/86400000;//86400000=1 day in Miliseconds
		 System.out.println(diff+" Days");
	 }
}

public class Q4 {
	
	
	
	
	public static void main(String[] args) throws Exception {
		DateManipulator obj = new DateManipulator();
			obj.stringToDate("01-07-2025");
			Date d = new Date();
			obj.dateToString(d);
			 
			Date date1 = new Date(125,6,1);
			Date date2 = new Date(125,6,20);
			obj.dateDiff(date1, date2);
	     
	}

}
