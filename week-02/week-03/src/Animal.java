public class Animal {

    public Animal(int hunger) {
        this.hunger = hunger;
    }

    public static void main(String[] args) {

    }

    int hunger = 50;
    int thirst = 50;

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
