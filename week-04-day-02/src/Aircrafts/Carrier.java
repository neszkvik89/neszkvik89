package Aircrafts;

import java.util.ArrayList;
import java.util.List;

public class Carrier extends Aircraft {
    int storedAmmo = 0;
    int healthPoint = 0;
    int allDamageDealt = 0;
    int allMissingAmmo = 0;
    List<Aircraft> myPlanes = new ArrayList<>();
    //The carrier itself will go on the list as well and it is always element nr. 0


    public int getAllDamageDealt() {
        return allDamageDealt;
    }

    public void setAllDamageDealt(int allDamageDealt) {
        this.allDamageDealt = allDamageDealt;
    }


    public int getAllMissingAmmo() {
        return allMissingAmmo;
    }

    public void setAllMissingAmmo(int allMissingAmmo) {
        this.allMissingAmmo = allMissingAmmo;
    }

    public Carrier(int storedAmmo, int healthPoint) {
        this.storedAmmo = storedAmmo;
        this.healthPoint = healthPoint;
    }

    public int getStoredAmmo() {
        return storedAmmo;
    }

    public void setStoredAmmo(int storedAmmo) {
        this.storedAmmo = storedAmmo;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void takeDamage (int dmgTaken) {
        setHealthPoint(this.healthPoint - dmgTaken);
    }

    public List<Aircraft> getMyPlanes() {
        return myPlanes;
    }

    public void setMyPlanes(List<Aircraft> myPlanes) {
        this.myPlanes = myPlanes;
    }

    public void add(Aircraft toAdd) {
        this.getMyPlanes().add(toAdd);
    }

    public int calcMissingAmmo() {
        int toReturn = 0;
        for (int i = 0; i < getMyPlanes().size(); i++) {
            this.setAllMissingAmmo(this.getAllMissingAmmo() + (this.getMyPlanes().get(i).getMaxAmmo() - this.getMyPlanes().get(i).getCurrentAmmo()));
        }
        return this.getAllMissingAmmo();
    }

    public void fill () throws Exception {

        if (this.getStoredAmmo() == 0) {
            throw new Exception("Aircraft carrier has 0 ammo stored!");
        }
            if (this.calcMissingAmmo() <= this.getStoredAmmo()) {
        for (int i = 1; i < this.myPlanes.size(); i++) {
            this.myPlanes.get(i).refill((Carrier)this.myPlanes.get(0));
        }
        this.calcMissingAmmo();
    } else {
        for (int i = 1; i < this.myPlanes.size(); i++) {
            if (this.myPlanes.get(i).getType() == "F35") {
                this.myPlanes.get(i).refill((Carrier)this.myPlanes.get(0));
            }
        }
    }

    }

    public void fight (Carrier enemyCarrier) {
        for (int i = 1; i < this.myPlanes.size(); i++) {
            this.setAllDamageDealt(this.getAllDamageDealt() + this.myPlanes.get(i).fight());
        }
        enemyCarrier.takeDamage(this.getAllDamageDealt());
        if (enemyCarrier.getHealthPoint() <= 0) {
            System.out.println("It's dead Jim! :( Enemy carrier destroyed!");
        }
    }

    public void getStatus () {
        System.out.println("HP: " + this.getHealthPoint() + " , Aircraft count: " + (this.myPlanes.size() -1)
                + ", Ammo Storage: " + this.getStoredAmmo() + ", Total damage :" + this.getAllDamageDealt());
        System.out.println("Aircrafts:");
        System.out.println();
        for (int i = 1; i < this.myPlanes.size(); i++) {
            this.myPlanes.get(i).getStatus();
        }
    }

    public static void main(String[] args) {

        Carrier myCarrier = new Carrier(35, 3465);
        myCarrier.myPlanes.add(myCarrier); //always has to be in position 0
        myCarrier.myPlanes.add(new F16());
        myCarrier.myPlanes.add(new F35());
        myCarrier.myPlanes.add(new F35());
        myCarrier.myPlanes.add(new F16());
        myCarrier.myPlanes.add(new F16());

        Carrier otherCarrier = new Carrier(417, 1325);
        otherCarrier.myPlanes.add(otherCarrier); //always has to be in position 0
        otherCarrier.myPlanes.add(new F16());
        otherCarrier.myPlanes.add(new F16());
        otherCarrier.myPlanes.add(new F35());
        otherCarrier.myPlanes.add(new F35());
        otherCarrier.myPlanes.add(new F16());

        try {
            myCarrier.fill();
        } catch (Exception e) {
            System.out.println("Carrier has 0 ammo stored, filling process failed.");
        }
        myCarrier.fight(otherCarrier);
        myCarrier.getStatus();

    }
}
