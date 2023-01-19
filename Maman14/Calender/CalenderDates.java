

import java.util.Calendar;


/**

 The CalenderDates class is responsible for determining the number of days in a given month.
 */
public class CalenderDates {

    /**
     Returns the number of days in a given month and year
     @param month the month of which the number of days is to be determined
     @param year the year of which the number of days is to be determined
     @return the number of days in the given month and year
     */
    public int getDaysInMonth(int month, int year){
        Calendar cal=Calendar.getInstance(); // creates a new Calendar object
        cal.set(Calendar.DATE, 1); // sets the date to the first day of the month
        cal.set(Calendar.MONTH, month+1); // sets the month
        cal.set(Calendar.YEAR, year); // sets the year
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)-1); // sets the date to the last day of the month
        return cal.get(Calendar.DATE); // returns the number of days in the month
    }
}