class Employees {
    String name;
    int id;
    double salary;

    Employees(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
        System.out.println("------------------------");
    }
}

public class Employee {
    public static void main(String[] args) {
        Employees e1 = new Employees("Shivam", 101, 50000);
        Employees e2 = new Employees("Rahul", 102, 60000);

        e1.displayDetails();
        e2.displayDetails();
    }
}
