package simulator;

import simulator.transport.Flyable;

import java.util.*;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable)) {
            return;
        } else {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }
    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
