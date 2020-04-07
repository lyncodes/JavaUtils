package calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class MyCalendar {
    public static void main(String[] args) {
        System.out.println("====calendar usage====");
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.YEAR, -1);
        System.out.println(f.format(calendar.getTime()));

        Date d1 =  calendar.getTime();
        calendar.add(Calendar.YEAR, -1);
        Date d2 = calendar.getTime();
    }
}
