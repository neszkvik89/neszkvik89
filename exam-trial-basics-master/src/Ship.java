import java.util.ArrayList;
import java.util.List;

public class Ship {
  List<Pirate> myPirates = new ArrayList<>();

  public void addNewPirate(Pirate newPirate) {
    boolean doubleCaptain = false;
    if (!newPirate.isCaptain()) {
      this.myPirates.add(newPirate);
    } else {
      for (int i = 0; i < myPirates.size(); i++) {
        if (myPirates.get(i).isCaptain()) {
          doubleCaptain = true;
        }
      }
      if (!doubleCaptain) {
        this.myPirates.add(newPirate);
      }
    }
  }

  public ArrayList<String> getPoorPirates() {
    ArrayList<String> poorPirates = new ArrayList<>();
    for (int i = 0; i < myPirates.size(); i++) {
      if (myPirates.get(i).getGold() < 15 && myPirates.get(i).isWoodenLeg()) {
        poorPirates.add(myPirates.get(i).getName());
      }
    }
    return poorPirates;
  }

  public int getGolds() {
    int sumGold = 0;
    for (int i = 0; i < myPirates.size(); i++) {
      sumGold += myPirates.get(i).getGold();
    }
    return sumGold;
  }

  public void lastDayOnTheShip() {
    for (int i = 0; i < myPirates.size(); i++) {
      myPirates.get(i).party();
    }
  }

  public void prepareForBattle() {
    for (int i = 0; i < myPirates.size(); i++) {
      myPirates.get(i).work();
      myPirates.get(i).work();
      myPirates.get(i).work();
      myPirates.get(i).work();
      myPirates.get(i).work();
    }
    this.lastDayOnTheShip();
  }

  public static void main(String[] args) {
    Pirate joe = new Pirate("Joe", false, true);
    Pirate bob = new Pirate("Bob", true, false);
    Pirate tim = new Pirate("Joe", false, false);
    Pirate tom = new Pirate("Joe", true, false);
    tom.setGold(44);
    Ship myShip = new Ship();
    myShip.addNewPirate(joe);
    myShip.addNewPirate(bob);
    myShip.addNewPirate(tim);
    myShip.addNewPirate(tom);
    myShip.getPoorPirates();
    myShip.prepareForBattle();
    System.out.println(myShip.myPirates);

  }

}
