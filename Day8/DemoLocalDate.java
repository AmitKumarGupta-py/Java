package Day8;
import java.time.*;
import java.util.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.stream.*;


public class DemoLocalDate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Current time: " + today);

        LocalDate diwali = LocalDate.of(2025,11,1);
        System.out.println(diwali);

        Period timetodiwali = today.until(diwali);
        System.out.println(timetodiwali);
        System.out.println(timetodiwali.getYears() + "years(s) "+ timetodiwali.getMonths() + "months(s) "+ timetodiwali.getDays() + "days(s) ");
        
        long daystodiwali = today.until(diwali,ChronoUnit.DAYS);
        System.out.println(daystodiwali + " Days " );

        System.out.println(today.getDayOfMonth());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getMonthValue());
        System.out.println(today.getMonth());
        System.out.println(today.getYear());

        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
        LocalDate nextFriday = today.plus(7,ChronoUnit.DAYS);
        System.out.println(nextFriday);

        System.out.println("-------------------------------------");

        Stream<LocalDate> currentYear = LocalDate.of(2024,1,1).datesUntil(LocalDate.of(2025,1,1));
//finding out all black friday in year
        currentYear.filter((date)-> date.getDayOfWeek().equals(DayOfWeek.FRIDAY)).filter((date)-> date.getDayOfMonth()==13).forEach(System.out::println);
    
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek());
        System.out.println(today.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek()); //);

        System.out.println(today.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));

        System.out.println(today.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));


    }
}