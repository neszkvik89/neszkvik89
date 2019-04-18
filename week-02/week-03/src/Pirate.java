public class Pirate {

    public int getToxiMeter() {
        return toxiMeter;
    }

    public void setToxiMeter(int toxiMeter) {
        this.toxiMeter = toxiMeter;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
        System.out.println("A pirate died!");
    }

    private int toxiMeter = 0;
    private String name = "";
    private boolean isDead = false;
    private boolean isPassedOut = false;
    private boolean isCaptain = false;

    public boolean isPassedOut() {
        return isPassedOut;
    }

    public void setPassedOut(boolean passedOut) {
        isPassedOut = passedOut;
    }


    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public Pirate(String name) {
        this.name = name;
    }


    public static void brawl (Pirate pirate1, Pirate pirate2) {
        if (pirate1.isDead() == false && pirate2.isDead() == false) {
            int i = (int) (Math.random() * 3 + 1);
            if (i == 1) {
                pirate1.setDead(true);
                System.out.println("P1 died");
            } else if (i == 2) {
                pirate2.setDead(true);
                System.out.println("P2 died");
            } else {
                pirate1.setPassedOut(true);
                pirate2.setPassedOut(true);
                System.out.println("Both pirates passed out, having a good sleep now.");
            }
        } else {
            System.out.println("There is no fight, at least one of these pirates are already dead");
        }

    }

    public void die () {
        setDead(true);
    }

    public void howsItGoingMate() {
        if (isDead() == false) {
            if (getToxiMeter() < 4) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin? /The pirate passes out and sleeps it off/");
            }
        } else {
            System.out.println("He is dead!");
        }
    }

    public void drinkSomeRum () {
        if (isDead() == false) {
            setToxiMeter(getToxiMeter() + 1);
            System.out.println("A pirate had some rum!");
            if (getToxiMeter() == 4) {
                this.setPassedOut(true);
            }

        } else {
            System.out.println("He is dead");
        }

    }


    public static void main(String[] args) {

        Pirate joe = new Pirate("Joe");
        Pirate bob = new Pirate("Bob");
        bob.drinkSomeRum();
        bob.drinkSomeRum();
        bob.drinkSomeRum();
        bob.drinkSomeRum();
        bob.howsItGoingMate();
        bob.drinkSomeRum();
        bob.howsItGoingMate();
        bob.drinkSomeRum();

        Pirate.brawl(joe, bob);
    }
}
