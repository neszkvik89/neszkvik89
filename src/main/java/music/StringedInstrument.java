package main.java.music;

public abstract class StringedInstrument extends Instrument {

    private int numberOfStrings;

    public StringedInstrument(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public StringedInstrument() {
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play() {
        System.out.println(this.sound());
    }
    public abstract String sound();
}
