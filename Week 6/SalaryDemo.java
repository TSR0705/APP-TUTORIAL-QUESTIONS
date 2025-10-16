class Employee {
    double baseSalary = 50000;

    double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    double bonus = 20000;

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    double overtimePay = 10000;

    @Override
    double calculateSalary() {
        return baseSalary + overtimePay;
    }
}

public class SalaryDemo {
    public static void main(String[] args) {
        Employee m = new Manager();
        Employee d = new Developer();
        System.out.println("Manager salary: " + m.calculateSalary());
        System.out.println("Developer salary: " + d.calculateSalary());
    }
}
