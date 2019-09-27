package Demo;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorldClockTest {

    @Test
    void addCity() {
        WorldClock worldClock = new WorldClock();
        worldClock.addCity("Paris","Europe/Paris");
        List<CityLocalTime> cityLocalTimes = worldClock.getCityLocalTimes();
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        assertNotNull(cityLocalTimes);
        CityLocalTime inputLocalTime = cityLocalTimes.get(0);
        assertEquals("Paris",inputLocalTime.getCityName());
        assertEquals("2019-09-27 11:01",formatter.format(ZonedDateTime.now(zoneId).toLocalDateTime()));
    }
}