package Day8;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class DemoLocalTime {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime noon =  LocalTime.NOON;
        long diff = now.until(noon,ChronoUnit.MINUTES);
        System.out.println(diff);

        Duration interval = Duration.between(now, noon);
        System.out.println(interval);

        now = now.plusHours(1);
        now = now.plus(10,ChronoUnit.MINUTES);
        System.out.println(now);

        LocalDateTime dt = now.atDate(LocalDate.of(2024,10,10));
        System.out.println(dt);


    }
    
}
