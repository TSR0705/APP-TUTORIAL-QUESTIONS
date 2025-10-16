class Student {
    private int marks;
    private String name;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    void setMarks(int marks) { // package-private for access by Teacher only
        this.marks = marks;
    }
}

class Teacher {
    public void updateMarks(Student s, int marks) {
        s.setMarks(marks);
    }
}

public class MarksSystem {
    public static void main(String[] args) {
        Student st = new Student("Alice", 85);
        Teacher t = new Teacher();
        System.out.println("Student marks: " + st.getMarks());
        t.updateMarks(st, 95);
        System.out.println("Updated marks by teacher: " + st.getMarks());
    }
}
