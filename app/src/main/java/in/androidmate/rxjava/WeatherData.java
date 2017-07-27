package in.androidmate.rxjava;

import java.util.List;

/**
 * Created by anujgupta on 27/07/17.
 */

public class WeatherData {

    public Coordinates coord;
    public Local sys;
    public List<Weather> weathers;
    public String base;
    public Main main;
    public Wind wind;
    public Rain rain;
    public Cloud clouds;
    public long id;
    public long dt;
    public String name;
    public int cod;

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public Local getSys() {
        return sys;
    }

    public void setSys(Local sys) {
        this.sys = sys;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public static class Coordinates {
        public double lat;
        public double lon;
    }

    public static class Local {
        public String country;
        public long sunrise;
        public long sunset;
    }

    public static class Weather {
        public int id;
        public String main;
        public String description;
        public String icon;
    }

    public static class Main {
        public double temp;
        public double pressure;
        public double humidity;
        public double temp_min;
        public double temp_max;
        public double sea_level;
        public double grnd_level;
    }

    public static class Wind {
        public double speed;
        public double deg;
    }

    public static class Rain {
        public int threehourforecast;
    }

    public static class Cloud {
        public int all;
    }

}
