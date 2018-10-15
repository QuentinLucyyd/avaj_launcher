package simulator.transport;

import simulator.Coordinates;

abstract public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates _coord = new Coordinates(longitude, latitude, height);

        if (type.equals("Balloon"))
            return new Balloon(name, _coord);
        else if (type.equals("JetPlane"))
            return new JetPlane(name, _coord);
        else if (type.equals("Helicopter"))
            return new Helicopter(name, _coord);
        return null;
    }
}
