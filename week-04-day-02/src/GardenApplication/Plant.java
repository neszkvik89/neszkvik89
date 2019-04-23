package GardenApplication;

public class Plant {

    private double currentWaterLevel = 0d;
    private int sufficientWaterLevel = 0;
    private String color = "";
    private String type = "";

    public Plant() {
    }

    public Plant(int sufficientWaterLevel, String color, String type) {
        this.sufficientWaterLevel = sufficientWaterLevel;
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getSufficientWaterLevel() {
        return sufficientWaterLevel;
    }

    public void setSufficientWaterLevel(int sufficientWaterLevel) {
        this.sufficientWaterLevel = sufficientWaterLevel;
    }


    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public void setCurrentWaterLevel(double currentWaterLevel) {
        this.currentWaterLevel = currentWaterLevel;
    }

    public void getWatered (double waterAmount) {
        this.setCurrentWaterLevel(this.getCurrentWaterLevel() + waterAmount);
    }

    public void info () {
        if (this.getCurrentWaterLevel() >= this.getSufficientWaterLevel()) {
            System.out.println("The " + this.getColor() +  " " + this.getType() + " doesn't need water");
        } else {
            System.out.println("The " + this.getColor() +  " " + this.getType() + " needs water");
        }
    }
}
