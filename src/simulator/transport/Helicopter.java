package simulator.transport;

import simulator.Coordinates;
import simulator.WeatherTower;

public class Helicopter extends Aircraft implements  Flyable {
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String Curweather = this.weatherTower.getWeather(this.coordinates);
        if (Curweather == "SUN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            _Logger.writeToFile("Helicopter# " + this.name + "[" + this.id + "]" + " It's way to Hot up here");
        } else if (Curweather == "RAIN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            _Logger.writeToFile("Helicopter# " + this.name + "[" + this.id + "]" + " Damn not this rain again");
        } else if (Curweather == "FOG") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            _Logger.writeToFile("Helicopter# " + this.name + "[" + this.id + "]" + " Have you watched the movie 'The Fog'");
        } else if (Curweather == "SNOW") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            _Logger.writeToFile("Helicopter# " + this.name + "[" + this.id + "]" + " White Everywhere");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        _Logger.writeToFile("Tower says: Helicopter# " + this.name + "[" + this.id + "]" + " Has registered to weather Tower");
    }
}
