public class Animal {

    private int hunger = 50;
    private int thirst = 50;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public Animal(int hunger) {
        this.hunger = hunger;
    }

    public void eat (){
        hunger--;
    }

    public void drink (){
        thirst--;
    }

    public void play (){
        hunger++;
        thirst++;
    }
    //constructor that will not let you modify the default 50-50 values
    public Animal() {
    }

}
