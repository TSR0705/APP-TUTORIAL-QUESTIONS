class Vehicle {
    int speed;
    int fuelCapacity;

    public void start() {
        System.out.println("Vehicle started.");
    }
}

class Car extends Vehicle {
    int numDoors;

    public void openTrunk() {
        System.out.println("Trunk opened.");
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    public void doWheelie() {
        System.out.println("Bike doing wheelie!");
    }
}

class Truck extends Vehicle {
    int loadCapacity;

    public void loadGoods() {
        System.out.println("Goods loaded.");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.openTrunk();

        Bike bike = new Bike();
        bike.start();
        bike.doWheelie();

        Truck truck = new Truck();
        truck.start();
        truck.loadGoods();
    }
}
