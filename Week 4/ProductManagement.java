import java.util.ArrayList;

// Product class
class Product {
    String name;
    double price;
    int stock;

    Product(String n, double p, int s) {
        name = n;
        price = p;
        stock = s;
    }
}

// CartItem class for shopping cart items
class CartItem {
    Product product;
    int qty;

    CartItem(Product p, int q) {
        product = p;
        qty = q;
    }
}

// ShoppingCart class
class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(Product p, int qty) {
        if (p.stock >= qty) {
            items.add(new CartItem(p, qty));
            p.stock -= qty;
            System.out.println(qty + " x " + p.name + " added to cart.");
        } else {
            System.out.println("Not enough stock for " + p.name);
        }
    }

    void removeItem(String productName) {
        items.removeIf(c -> c.product.name.equals(productName));
        System.out.println(productName + " removed from cart.");
    }

    double calculateTotal() {
        double total = 0;
        for (CartItem c : items) {
            total += c.product.price * c.qty;
        }
        return total;
    }
}

// User class
class User {
    String name;
    ShoppingCart cart;

    User(String n) {
        name = n;
        cart = new ShoppingCart();
    }
}

// Main class for demo
public class ProductManagement {
    public static void main(String[] args) {
        // Create some products
        Product laptop = new Product("Laptop", 50000, 5);
        Product phone = new Product("Phone", 20000, 10);
        Product headphones = new Product("Headphones", 2000, 20);

        // Create a user
        User user = new User("Alice");

        // Add items to cart
        user.cart.addItem(laptop, 1);
        user.cart.addItem(phone, 2);
        user.cart.addItem(headphones, 3);

        // Display total
        System.out.println("Total: ₹" + user.cart.calculateTotal());

        // Remove an item
        user.cart.removeItem("Phone");

        // Display new total
        System.out.println("Total after removal: ₹" + user.cart.calculateTotal());
    }
}
