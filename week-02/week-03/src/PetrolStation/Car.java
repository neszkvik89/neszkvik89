package PetrolStation;

public class Car {

    private int gasAmount = 0;
    private int capacity = 100;
    private String carName = "";

    public Car(String carName) {
        this.carName = carName;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
