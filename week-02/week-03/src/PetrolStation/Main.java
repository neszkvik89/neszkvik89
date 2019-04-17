package PetrolStation;

public class Main {
    public static void main(String[] args) {
        Station thirdStation = new Station("thirdStation");
        Car thirdCar = new Car("thirdCar");
        thirdStation.refill(thirdStation, thirdCar);
        System.out.println(thirdCar.getGasAmount());
        System.out.println(thirdCar.getCapacity());
        System.out.println(thirdStation.getGasAmount());
    }


}
