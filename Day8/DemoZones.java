package Day8;

import java.time.LocalDateTime;
import java.time.Instant;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
 
public class DemoZones {

    public static void main(String[] args) {
        // Get all available zones
        Set<String> zoneids = ZoneId.getAvailableZoneIds();
        System.out.println(zoneids);

        //Asia/culcutta
        //America/Los Angeles

        LocalDateTime indialocal = LocalDateTime.now();

        System.out.println(indialocal);

        ZonedDateTime ist = indialocal.atZone(ZoneId.of("Asia/Culcutta"));
        System.out.println(ist);

        Instant instant = ist.toInstant();

        ZonedDateTime la = instant.atZone(ZoneId.of("America/Los Angeles"));
        System.out.println(la.toLocalDateTime());

    }


    
}
