package simulator;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};


    public static WeatherProvider getProvider() { return weatherProvider; }

    public static String getCurrentWeather(Coordinates coordinates) {
        int rand = coordinates.latitude + coordinates.longitude;
        return weather[rand % 4];
    }
}