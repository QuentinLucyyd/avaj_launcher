package simulator.transport;

import simulator.Coordinates;
import simulator.WeatherTower;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN") {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 4
            );
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5
            );
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3
            );
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15
            );
        }
    }

     public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
