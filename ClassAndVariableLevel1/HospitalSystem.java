class Patient {
    static String hospitalName = "City Care Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Arjun Mehta", 35, "Fever");
        Patient p2 = new Patient(2, "Sanya Kapoor", 28, "Fracture");

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();

        Patient.getTotalPatients();
    }
}
