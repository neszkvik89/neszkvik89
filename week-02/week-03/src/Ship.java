import java.util.ArrayList;

public class Ship {

    ArrayList<Pirate> thesePirates = new ArrayList<>();
    private boolean isWinner = false;
    private int aliveCrewNumber = 0;

    public Ship() {
    }

    public int getAliveCrewNumber() {
        return aliveCrewNumber;
    }

    public void setAliveCrewNumber(int aliveCrewNumber) {
        this.aliveCrewNumber = aliveCrewNumber;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void countAlivePirates() {
        aliveCrewNumber = 0;
        for (int i = 0; i < thesePirates.size(); i++) {
            if (thesePirates.get(i).isDead() == false) {
                aliveCrewNumber++;
            }
        }
    }

    public void fillShip() {
        int pirateAmount = (int) (Math.random() * 10 + 5);
        for (int i = 0; i < pirateAmount; i++) {
            this.thesePirates.add(new Pirate(""));
            if (i == 0) {
                this.thesePirates.get(i).setCaptain(true);
            }
        }
        aliveCrewNumber = this.thesePirates.size();
    }

    public boolean battle(Ship otherShip) {
        int casualties = 0;
        int rumAmount = 0;
        if (this.getAliveCrewNumber() - this.thesePirates.get(0).getToxiMeter() > otherShip.getAliveCrewNumber() - otherShip.thesePirates.get(0).getToxiMeter()) {
            this.setWinner(true);
            casualties = (int) (otherShip.getAliveCrewNumber() * Math.random() + 1);
            rumAmount = (int) (this.getAliveCrewNumber() * Math.random() + 1);
        } else {
            otherShip.setWinner(true);
            casualties = (int) (this.getAliveCrewNumber() * Math.random() + 1);
            rumAmount = (int) (otherShip.getAliveCrewNumber() * Math.random() + 1);
        }
        if (this.isWinner() == true) {
            for (int i = 0; i < otherShip.thesePirates.size(); i++) {
                if (otherShip.thesePirates.get(i).isDead() == false && casualties != 0) {
                    otherShip.thesePirates.get(i).setDead(true);
                    casualties--;
                }
            }

            for (int i = 0; i < this.thesePirates.size(); i++) {
                if (this.thesePirates.get(i).isDead() == false && rumAmount != 0) {
                    this.thesePirates.get(i).drinkSomeRum();
                    rumAmount--;
                }
            }
        } else {
            {
                for (int i = 0; i < this.thesePirates.size(); i++) {
                    if (this.thesePirates.get(i).isDead() == false && casualties != 0) {
                        this.thesePirates.get(i).setDead(true);
                        casualties--;
                    }
                }

                for (int i = 0; i < otherShip.thesePirates.size(); i++) {
                    if (otherShip.thesePirates.get(i).isDead() == false && rumAmount != 0) {
                        otherShip.thesePirates.get(i).drinkSomeRum();
                        rumAmount--;
                    }
                }
            }
        }
        System.out.println("Battle is over.");
        return this.isWinner();
    }
}
