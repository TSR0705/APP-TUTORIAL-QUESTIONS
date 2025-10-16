import java.util.*;

class Product {
    String name;
    double price;
    int stock;

    Product(String n, double p, int s) {
        name = n;
        price = p;
        stock = s;
    }

    void issue() {
        System.out.println("Issued: " + name);
    }

    void returned() {
        System.out.println("Returned: " + name);
    }

    void calculateFee(int d) {
        System.out.println("Fee: " + d);
    }
}

class Book extends Product {
    Book(String t, String a, int i) { super(t, 0, i); }
    void calculate(int d) { System.out.println("Book Fee: " + d * stock); }
}

class DVD extends Product {
    DVD(String t, String a, int i) { super(t, 0, i); }
    void calculateFee(int d) { System.out.println("DVD Fee: " + d * 5); }
}

public class LibraryManagement {
    public static void main(String[] args) {
        ArrayList<Product> items = new ArrayList<>();
        items.add(new Book("Java", "James", 1));
        items.add(new Book("Tah", "Tom", 2));
        items.add(new DVD("Movie", "Sam", 3));
        for (Product x : items) {
            x.issue();
            x.calculateFee(3);
            x.returned();
        }
    }
}
