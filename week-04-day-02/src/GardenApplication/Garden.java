package GardenApplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    public static void main(String[] args) {
        int wetOnes = 0;

        List<Plant> myGarden = new ArrayList<>();
        myGarden.add(new Tree(6, "Purple", "Tree"));
        myGarden.add(new Tree(6, "Orange", "Tree"));
        myGarden.add(new Flower(6, "Yellow", "Flower"));
        myGarden.add(new Flower (6, "Blue", "Flower"));

        for (int i = 0; i < myGarden.size(); i++) {
            myGarden.get(i).info();
        }
        System.out.println();
        System.out.println("Watering with 40");

        for (int i = 0; i < myGarden.size(); i++) {
            myGarden.get(i).getWatered(40/myGarden.size());
            if (myGarden.get(i).getCurrentWaterLevel() >= myGarden.get(i).getSufficientWaterLevel()) {
                wetOnes++;
            }
        }
        System.out.println();

        for (int i = 0; i < myGarden.size(); i++) {
            myGarden.get(i).info();
        }
        System.out.println();
        System.out.println("Watering with 70");

        for (int i = 0; i < myGarden.size(); i++) {
            if (myGarden.get(i).getCurrentWaterLevel() < myGarden.get(i).getSufficientWaterLevel()){
                myGarden.get(i).getWatered(70/myGarden.size() - wetOnes);

                if (myGarden.get(i).getCurrentWaterLevel() >= myGarden.get(i).getSufficientWaterLevel()) {
                    wetOnes++;
                }
            }
        }
        System.out.println();

        for (int i = 0; i < myGarden.size(); i++) {
            myGarden.get(i).info();
        }
    }
}
