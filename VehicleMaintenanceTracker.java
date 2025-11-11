import java.time.LocalDate;

class ServiceOverdueException extends Exception {
    public ServiceOverdueException(String message) {
        super(message);
    }
}

class InvalidMileageException extends Exception {
    public InvalidMileageException(String message) {
        super(message);
    }
}

class Vehicle {
    private String vehicleNumber;
    private LocalDate serviceDate;
    private int mileage;

    public Vehicle(String vehicleNumber, LocalDate serviceDate, int mileage) {
        this.vehicleNumber = vehicleNumber;
        this.serviceDate = serviceDate;
        this.mileage = mileage;
    }

    public void checkMaintenance() throws ServiceOverdueException, InvalidMileageException {
        LocalDate today = LocalDate.now();

        if (mileage < 0) {
            throw new InvalidMileageException("Invalid mileage entered for vehicle " + vehicleNumber + ".");
        }

        if (serviceDate.isBefore(today)) {
            throw new ServiceOverdueException("Service overdue for vehicle " + vehicleNumber + ".");
        }

        System.out.println("Vehicle " + vehicleNumber + " is in good condition. No maintenance needed.");
    }
}

public class VehicleMaintenanceTracker {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("UP80 AB 1234", LocalDate.of(2024, 12, 10), 15000);
        Vehicle v2 = new Vehicle("DL10 XY 5678", LocalDate.of(2025, 12, 15), -500);
        Vehicle v3 = new Vehicle("MH12 CD 9999", LocalDate.of(2026, 1, 20), 18000);

        Vehicle[] vehicles = {v1, v2, v3};

        for (Vehicle v : vehicles) {
            try {
                v.checkMaintenance();
            } catch (ServiceOverdueException e) {
                System.out.println(e.getMessage());
            } catch (InvalidMileageException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
