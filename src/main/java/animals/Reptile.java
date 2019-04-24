package main.java.animals;

public class Reptile extends EggLayers {

    public Reptile(String name) {
        super(name);
    }

    @Override
    public String eat() {
        return "Reptiles prefer to eat meat";
    }

    @Override
    public String move() {
        return "Reptiles move using their legs";
    }
}
