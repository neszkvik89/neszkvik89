package main.java.animals;

public class Helicopter extends Vehicle implements Flyable{
    @Override
    public String land() {
        return " lands smoothly causing a tiny whirlwind";
    }

    @Override
    public String fly() {
        return " flies using its rotors fighting gravity";
    }

    @Override
    public String takeOff() {
        return " takes of by creating downwards air pressure";
    }
}
