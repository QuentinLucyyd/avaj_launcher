package simulator.transport;

import simulator.Coordinates;
import simulator.Logger;
import simulator.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String Curweather = this.weatherTower.getWeather(this.coordinates);
        if (Curweather == "SUN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            _Logger.writeToFile("Balloon# " + this.name + "[" + this.id + "]" + " Sunny Skies throughout");
        } else if (Curweather == "RAIN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            _Logger.writeToFile("Balloon# " + this.name + "[" + this.id + "]" + " Brace yourself, it's about to get wet");
        } else if (Curweather == "FOG") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            _Logger.writeToFile("Balloon# " + this.name + "[" + this.id + "]" + " I cannot to see anything");
        } else if (Curweather == "SNOW") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            _Logger.writeToFile("Balloon# " + this.name + "[" + this.id + "]" + " Ooh Time to build a Snowman");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Logging to File Now");
        _Logger.writeToFile("Tower says: Balloon# " + this.name + "[" + this.id + "]" + " Has registered to weather Tower");
    }
}
