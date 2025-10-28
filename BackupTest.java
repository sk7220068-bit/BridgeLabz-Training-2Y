import java.io.*;

class Employee implements Serializable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class BackupTest {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Amit", 55000.0);
        String file = "employee_backup.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(emp);
            System.out.println("Employee data serialized for backup.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Employee restored = (Employee) in.readObject();
            System.out.println("Restored Employee: " + restored.name + ", Salary: " + restored.salary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
