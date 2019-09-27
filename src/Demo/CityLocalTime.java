package Demo;

import java.time.LocalDateTime;

public class CityLocalTime {
    private String cityName;
    private LocalDateTime cityTime;
    public CityLocalTime(String cityName, LocalDateTime cityTime){
        this.cityName = cityName;
        this.cityTime = cityTime;
    }
    public String getCityName(){
        return cityName;
    }
    public LocalDateTime getCityTime(){
        return cityTime;
    }
}
