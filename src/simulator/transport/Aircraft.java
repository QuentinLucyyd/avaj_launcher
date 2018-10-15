package simulator.transport;

import simulator.Coordinates;
import simulator.Logger;

abstract public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected static Logger _Logger = new Logger();

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    protected long nextId() {
        return (++idCounter);
    }
}
