import java.util.ArrayList;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void showDetails() {
        System.out.println("   Employee: " + name + " | Role: " + role);
    }
}

class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showDepartmentDetails() {
        System.out.println(" Department: " + deptName);
        for (Employee e : employees) {
            e.showDetails();
        }
    }

    public void clearDepartment() {
        employees.clear();
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showCompanyDetails() {
        System.out.println("\nCompany: " + companyName);
        for (Department d : departments) {
            d.showDepartmentDetails();
        }
    }

    public void closeCompany() {
        for (Department d : departments) {
            d.clearDepartment();
        }
        departments.clear();
        System.out.println("\nCompany " + companyName + " has been closed. All departments and employees removed.");
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");

        Department dept1 = new Department("IT");
        dept1.addEmployee("Alice", "Developer");
        dept1.addEmployee("Bob", "Tester");

        Department dept2 = new Department("HR");
        dept2.addEmployee("Charlie", "HR Manager");

        company.addDepartment(dept1);
        company.addDepartment(dept2);

        company.showCompanyDetails();

        company.closeCompany();
    }
}
