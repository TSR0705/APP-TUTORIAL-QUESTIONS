class Mobile {
    String brand, model;
    double price;

    Mobile(String b, String m, double p) {
        brand = b;
        model = m;
        price = p;
    }

    public void showDetails() {
        System.out.println("Mobile brand: " + brand);
        System.out.println("Mobile model: " + model);
        System.out.println("Mobile price: " + price);
    }
}

public class MobileDemo {
    public static void main(String[] args) {
        Mobile m1 = new Mobile("Samsung", "521", 6000);
        Mobile m2 = new Mobile("Apple", "iPhone 13", 7000);
        Mobile m3 = new Mobile("One Plus", "Nord 2", 5000);
        m1.showDetails();
        m2.showDetails();
        m3.showDetails();
    }
}
