class Patient {
    String name;
    int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class InPatient extends Patient {
    int roomNumber;

    public InPatient(String name, int age, int roomNumber) {
        super(name, age);
        this.roomNumber = roomNumber;
    }
}

class OutPatient extends Patient {
    public OutPatient(String name, int age) {
        super(name, age);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("Bob", 45, 101);
        OutPatient outPatient = new OutPatient("Carol", 30);

        System.out.println("InPatient: " + inPatient.name + ", Age: " + inPatient.age + ", Room: " + inPatient.roomNumber);
        System.out.println("OutPatient: " + outPatient.name + ", Age: " + outPatient.age);
    }
}
