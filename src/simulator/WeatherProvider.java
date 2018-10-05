package simulator;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int seed = coordinates.getLongitude() + coordinates.getLatitude();

        return weather[seed % 4];
    }
}
