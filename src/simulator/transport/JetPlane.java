package simulator.transport;

import simulator.Coordinates;
import simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String Curweather = this.weatherTower.getWeather(this.coordinates);
        if (Curweather == "SUN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            _Logger.writeToFile("JetPlane# " + this.name + "[" + this.id + "]" + " So much Sun!!");
        } else if (Curweather == "RAIN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() - 5, this.coordinates.getHeight());
            _Logger.writeToFile("JetPlane# " + this.name + "[" + this.id + "]" + " Jones, we have rain");
        } else if (Curweather == "FOG") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
            _Logger.writeToFile("JetPlane# " + this.name + "[" + this.id + "]" + " Fogy Fogy");
        } else if (Curweather == "SNOW") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            _Logger.writeToFile("JetPlane# " + this.name + "[" + this.id + "]" + " Snowy Days Ahead!! ");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        _Logger.writeToFile("Tower says: JetPlane# " + this.name + "[" + this.id + "]" + " Has registered to weather Tower");
    }
}
