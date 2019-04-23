package Aircrafts;

public class Aircraft {
    private int maxAmmo = 0;
    private int currentAmmo = 0;
    private int baseDamage = 0;
    private int allDamage = 0;
    private String type = "";
    private boolean priority = false;


    public Aircraft() {
    }

    public Aircraft(int maxAmmo, int baseDamage, String type, boolean priority) {
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
        this.type = type;
        this.priority = priority;
    }

    public void getStatus() {
        System.out.println("Type " + this.getType() + ", Ammo: " + this.getCurrentAmmo() + ", Base Damage: "
                + this.getBaseDamage() + ", All Damage: " + this.getAllDamage());
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getAllDamage() {
        return allDamage;
    }

    public void setAllDamage(int allDamage) {
        this.allDamage = allDamage;
    }


    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    public void setCurrentAmmo(int currentAmmo) {
        this.currentAmmo = currentAmmo;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int fight () {
        int damage = this.getCurrentAmmo() * this.getBaseDamage();
        setCurrentAmmo(0);
        this.setAllDamage(this.getAllDamage() + damage);
        return damage;
    }

    public int refill (Carrier myCarrier) {
        if (myCarrier.getStoredAmmo() <= this.getMaxAmmo() - this.getCurrentAmmo()) {
            this.setCurrentAmmo(this.getCurrentAmmo() + myCarrier.getStoredAmmo());
            myCarrier.setStoredAmmo(0);
            return 0;
        } else {
            int temp = this.getCurrentAmmo();
            this.setCurrentAmmo(this.getMaxAmmo());
            myCarrier.setStoredAmmo(myCarrier.getStoredAmmo() - (this.getCurrentAmmo() - temp));
            return myCarrier.getStoredAmmo() - (this.getCurrentAmmo() - temp);
        }
    }
}
