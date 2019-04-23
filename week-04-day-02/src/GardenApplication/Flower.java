package GardenApplication;

public class Flower extends Plant {
    public Flower(int sufficientWaterLevel, String color, String type) {
        super(sufficientWaterLevel, color, type);
        this.setType("Flower");
    }

    @Override
    public void getWatered(double waterAmount) {
        super.getWatered(waterAmount * 0.75);
    }
}
