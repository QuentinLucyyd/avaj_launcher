package simulator;

import simulator.transport.AircraftFactory;
import simulator.transport.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SyntaxError extends Exception {

    public SyntaxError(String message) {
        super(message);
    }

}

public class Simulator {
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    private static WeatherTower weatherTower;
    private static Logger _Log = new Logger();

    public Simulator(){}

    public static void main(String[] args) {
        /* File Reading Variables */
        BufferedReader  _bufferReader;
        FileReader      _fileReader;

        /* Main Java Variables */
        int             _simulationRun;
        weatherTower =  new WeatherTower();

        if (args.length == 0) {
            System.out.println("[avaJ_Launcher: (Error: 00)]: No Scenario Given");
            return ;
        }

        try {
            _fileReader = new FileReader(args[0]);
            _bufferReader = new BufferedReader(_fileReader);

            String _Line;
            _Line = _bufferReader.readLine();

            _simulationRun = Integer.parseInt(_Line);

            if (_simulationRun < 0)
                throw new SyntaxError("[avaJ_Launcher: (Error 02)]: Syntax Error , Scenario number not given / valid");

            while ((_Line = _bufferReader.readLine()) != null) {
                if (_Line.split(" ").length < 5)
                    throw new SyntaxError("[avaJ_Launcher: (Error 02)]: Syntax Error , Invalid Syntax");

                Flyable _new = AircraftFactory.newAircraft(_Line.split(" ")[0], _Line.split(" ")[1],
                        Integer.parseInt(_Line.split(" ")[2]),Integer.parseInt(_Line.split(" ")[3]),
                        Integer.parseInt(_Line.split(" ")[4]));

                if (_new != null)
                    flyables.add(_new);
            }

            System.out.println(flyables.size());

            for (Flyable flyable : flyables) {
                flyable.registerTower(weatherTower);
            }

            Iterator _flyablesIter = flyables.iterator();

            if (_flyablesIter.hasNext()) {
                Flyable _current = (Flyable)_flyablesIter.next();
                _current.registerTower(weatherTower);
            }

            for (int i = 1; i <= _simulationRun; i++)
                weatherTower.changeWeather();

        } catch (FileNotFoundException e) {
            System.out.println("[avaJ_Launcher: (Error: 03)]: Could not find the file " + args[0]);
        } catch (IOException e) {
            System.out.println(e);
        } catch (SyntaxError e) {
            e.printStackTrace();
        } catch(NumberFormatException e) {
            System.out.println("[avaJ_Launcher: (Error: 04)]: Syntax Error , Scenario number not given / valid");
        } finally {
            _Log.closeFile();
        }
    }
}
