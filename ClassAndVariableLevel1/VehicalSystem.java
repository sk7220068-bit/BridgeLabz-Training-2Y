class Vehicle {
    static double registrationFee = 5000.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Rohan Singh", "Car");
        Vehicle v2 = new Vehicle("DL09XY5678", "Neha Gupta", "Bike");

        v1.displayDetails();
        System.out.println();
        v2.displayDetails();

        Vehicle.updateRegistrationFee(7000);
        System.out.println("\nAfter updating registration fee:\n");

        v1.displayDetails();
        System.out.println();
        v2.displayDetails();
    }
}
