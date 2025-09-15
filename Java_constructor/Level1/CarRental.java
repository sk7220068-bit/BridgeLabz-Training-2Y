class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    public CarRental() {
        this.customerName = "";
        this.carModel = "";
        this.rentalDays = 0;
        this.costPerDay = 0.0;
    }

    public CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
        this.costPerDay = other.costPerDay;
    }

    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                           ", Days: " + rentalDays + ", Cost/Day: " + costPerDay +
                           ", Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Alice", "Toyota Corolla", 5, 1500.0);
        CarRental r3 = new CarRental(r2);

        System.out.println("Default Rental:");
        r1.display();

        System.out.println("Parameterized Rental:");
        r2.display();

        System.out.println("Copy Rental:");
        r3.display();
    }
}
