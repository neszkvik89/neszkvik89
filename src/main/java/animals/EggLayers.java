package main.java.animals;

public abstract class EggLayers extends Animal {

    public EggLayers(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs.";
    }

}
