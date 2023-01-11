

import java.util.Calendar;


public class CalenderDates {

    public int getDaysInMonth(int month, int year){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, month+1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)-1);

        return cal.get(Calendar.DATE);
    }
}
