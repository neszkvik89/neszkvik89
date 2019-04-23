package GardenApplication;

public class Tree extends Plant {
    public Tree(int sufficientWaterLevel, String color, String type) {
        super(sufficientWaterLevel, color, type);
        this.setType("Tree");
    }

    @Override
    public void getWatered(double waterAmount) {
        super.getWatered(waterAmount * 0.4);
    }
}
