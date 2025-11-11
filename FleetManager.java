// FleetManager.java
import java.util.*;

class Vehicle { String name; Vehicle(String n) { name = n; } public String toString() { return name; } }
class Truck extends Vehicle { Truck(String n) { super(n); } }
class Bike extends Vehicle { Bike(String n) { super(n); } }

public class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T v) { fleet.add(v); }
    public void showFleet() { System.out.println("Fleet: " + fleet); }

    public static void main(String[] args) {
        FleetManager<Truck> trucks = new FleetManager<>();
        trucks.addVehicle(new Truck("Volvo"));
        trucks.addVehicle(new Truck("Tata"));
        trucks.showFleet();

        FleetManager<Bike> bikes = new FleetManager<>();
        bikes.addVehicle(new Bike("Yamaha"));
        bikes.addVehicle(new Bike("Royal Enfield"));
        bikes.showFleet();
    }
}
