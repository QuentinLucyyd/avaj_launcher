package simulator.transport;

import simulator.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
}
