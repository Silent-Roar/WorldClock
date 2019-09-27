package Demo;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorldClock {
    private List<CityLocalTime> cityLocalTimes;
    public WorldClock(){
        this.cityLocalTimes = new ArrayList<>();
    }
    public void addCity(String cityName,String UTC){
        ZoneId zoneId = ZoneId.of(UTC);
        CityLocalTime cityLocalTime = new CityLocalTime(cityName, ZonedDateTime.now(zoneId).toLocalDateTime());
        cityLocalTimes.add(cityLocalTime);
    }
    public List<CityLocalTime>getCityLocalTimes(){return this.cityLocalTimes;}
}
