package simulator;

import simulator.transport.Flyable;

import java.util.ArrayList;

abstract public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public Tower(){}

    public void register(Flyable flyable) {
        if (!this.observers.contains(flyable)) {
            this.observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        if (this.observers.contains(flyable)) {
            this.observers.remove(flyable);
        }
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            this.observers.get(i).updateConditions();
        }
    }
}
