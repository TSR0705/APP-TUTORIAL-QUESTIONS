class Employee {
    String name;
    int ID;
    float salary;

    Employee(String n, int id, float s) {
        name = n;
        ID = id;
        salary = s;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Poorna", 29, 2900000);
        Employee emp2 = new Employee("Saranya", 69, 30000);
        emp1.displayDetails();
        emp2.displayDetails();
    }
}
