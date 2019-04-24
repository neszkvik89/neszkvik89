package FleetOfThings;

public class Thing implements Comparable <Thing> {
    private String name;
    private boolean completed;

    public Thing(String name) {
        this.name = name;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }

    @Override
    public int compareTo(Thing otherThing) {
        if (this.completed) {
            if (otherThing.completed) {
                return this.name.compareTo(otherThing.name);
            }
            else {
                return 1;
            }
        }
        else {
            if (!otherThing.completed) {
                return this.name.compareTo(otherThing.name);
            }
            else {
                return -1;
            }
        }
    }
}
