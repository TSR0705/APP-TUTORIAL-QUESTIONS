class Admission {
    void admissionProcess() {
        System.out.println("Generic admission process");
    }
}

class UndergraduateAdmission extends Admission {
    @Override
    void admissionProcess() {
        System.out.println("Merit + Entrance Test");
    }
}

class PostgraduateAdmission extends Admission {
    @Override
    void admissionProcess() {
        System.out.println("Written Test + Interview");
    }
}

public class AdmissionDemo {
    public static void main(String[] args) {
        Admission ug = new UndergraduateAdmission();
        Admission pg = new PostgraduateAdmission();
        ug.admissionProcess();
        pg.admissionProcess();
    }
}
