class Student {
    int rollno;
    String name;
    double marks;

    void display() {
        System.out.println("Roll No: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.rollno = 1;
        s1.name = "Saranya";
        s1.marks = 96;
        Student s2 = new Student();
        s2.rollno = 2;
        s2.name = "world";
        s2.marks = 76;
        s1.display();
        s2.display();
    }
}
