package Day9;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;
import java.time.DayOfWeek;
import java.util.Scanner;
import java.time.LocalDateTime;

public class DateTimeAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter your birth date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(inputDate, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);

        System.out.println("You are "  + age.getYears() + "years" + age.getMonths() + "months" + age.getDays() + "days old");

        
        System.out.print("Enter the year to calculate Programmer's Day: ");
        int programmersYear = scanner.nextInt();
        LocalDate programmersDay = calculateProgrammersDay(programmersYear);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println("Programmer's Day in " + programmersYear + " is: " + programmersDay.format(dateFormatter));

        
        scanner.nextLine(); 
        System.out.print("Enter departure time from Mumbai (yyyy-MM-dd HH:mm: ");
        String departureInput = scanner.nextLine();
        System.out.print("Enter arrival time in New York (yyyy-MM-dd HH:mm: ");
        String arrivalInput = scanner.nextLine();

        
        ZoneId mumbaiZone = ZoneId.of("Asia/Kolkata");
        ZoneId newYorkZone = ZoneId.of("America/New_York");

        
        ZonedDateTime departureTime = ZonedDateTime.of(LocalDateTime.parse(departureInput.replace(" ", "T")), mumbaiZone);
        ZonedDateTime arrivalTime = ZonedDateTime.of(LocalDateTime.parse(arrivalInput.replace(" ", "T")), newYorkZone);

       
        Duration flightDuration = Duration.between(departureTime, arrivalTime);
        long hours = flightDuration.toHours();
        long minutes = flightDuration.toMinutes() % 60;
        System.out.println("Flight Duration: " + hours + "hours" +  minutes + "minutes");

        
        System.out.print("Enter a year to check which months start on a Sunday: ");
        int year = scanner.nextInt();
        System.out.println("Months that start on a Sunday in " + year + ":");
        
        for (int month = 1; month <= 12; month++) {
            LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
            if (firstDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
            }
        }

        
        scanner.close();
    }

    public static LocalDate calculateProgrammersDay(int year) {
        boolean isLeapYear = LocalDate.of(year, 1, 1).isLeapYear(); 
        return isLeapYear ? LocalDate.of(year, 9, 12) : LocalDate.of(year, 9, 13);
    }
}
