import java.util.ArrayList;

public class Farm {

    int slots = 0;
    ArrayList<Animal> myAnimals = new ArrayList<>();

    public Farm(int slots, ArrayList<Animal> myAnimals) {
        this.slots = slots;
        this.myAnimals = myAnimals;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }


    public ArrayList<Animal> getMyAnimals() {
        return myAnimals;
    }

    public void setMyAnimals(ArrayList<Animal> myAnimals) {
        this.myAnimals = myAnimals;
    }

    public void slaughter () {

        int i = 0;
        int indexOfTarget = 0;
        int maxHunger = Integer.MAX_VALUE;
        for (i = 0; i < myAnimals.size(); i++) {
            if (myAnimals.get(i).getHunger() < maxHunger) {
                maxHunger = myAnimals.get(i).getHunger();
                indexOfTarget = i;
            }
        }
        myAnimals.remove(indexOfTarget);
        System.out.println("Animal died, " + String.valueOf(this.slots - myAnimals.size()) + " slots left.");
    }

    public void breed () {
        if (this.slots > myAnimals.size()) {
            this.slots--;
            myAnimals.add(new Animal((int) Math.random() * 100 + 1));
        } else {
            System.out.println("No more slots, time to slaughter!");
        }
    }
    public static void main(String[] args) {
        ArrayList<Animal> myAnimals = new ArrayList<>();
        myAnimals.add(new Animal(52));
        myAnimals.add(new Animal(17));
        myAnimals.add(new Animal(22));
        myAnimals.add(new Animal(34));
        myAnimals.add(new Animal(2));
        myAnimals.add(new Animal(43));
        myAnimals.add(new Animal(100));
        myAnimals.add(new Animal(4));
        myAnimals.add(new Animal(2));
        myAnimals.add(new Animal(76));

        Farm myFarm = new Farm(10, myAnimals);
        myFarm.slaughter();
        myFarm.slaughter();
        myFarm.slaughter();
    }
}
