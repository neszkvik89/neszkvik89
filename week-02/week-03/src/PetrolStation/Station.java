package PetrolStation;

public class Station {

    private int gasAmount = 5000;
    private String stationName = "";

    public Station(String stationName) {
        this.stationName = stationName;
    }


    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }


    public void refill(Station station, Car car) {
        car.setGasAmount(car.getCapacity());
        station.setGasAmount(station.gasAmount - 100);
        car.setCapacity(0);
    }
}
