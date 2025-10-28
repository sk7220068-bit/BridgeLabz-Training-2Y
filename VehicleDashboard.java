interface Vehicle {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class Car implements Vehicle {
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Electric Car speed: 100 km/h");
    }

    public void displayBattery() {
        System.out.println("Battery: 85%");
    }
}

public class VehicleDashboard {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new ElectricCar();

        v1.displaySpeed();
        v1.displayBattery();

        v2.displaySpeed();
        v2.displayBattery();
    }
}
