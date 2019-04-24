package main.java.animals;

public class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "mating and giving birth.";
    }

    @Override
    public String eat() {
        return "Mammals eat all kinds of food";
    }

    @Override
    public String move() {
        return "Mammals move in mysterious ways";
    }
}
