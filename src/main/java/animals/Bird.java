package main.java.animals;

public class Bird extends EggLayers implements Flyable{

    public Bird(String name) {
        super(name);
    }

    @Override
    public String eat() {
        return "Birds eat worms, nuts, etc.";
    }

    @Override
    public String move() {
        return "Birds fly of course, you dummy!";
    }

    @Override
    public String land() {
        return " lands on its feet, easy.";
    }

    @Override
    public String fly() {
        return " flies majestically";
    }

    @Override
    public String takeOff() {
        return " takes off using a helicopter-like method";
    }
}
