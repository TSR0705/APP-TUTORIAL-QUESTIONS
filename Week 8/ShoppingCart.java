import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCart extends JFrame {
    JCheckBox laptop, phone, headphones;
    JButton billBtn;
    JTextArea billArea;
    int laptopPrice = 70000, phonePrice = 40000, headphonesPrice = 2000;

    public ShoppingCart() {
        super("Shopping Cart");
        setLayout(new FlowLayout());

        laptop = new JCheckBox("Laptop");
        phone = new JCheckBox("Phone");
        headphones = new JCheckBox("Headphones");
        billBtn = new JButton("Generate Bill");
        billArea = new JTextArea(8, 20);
        billArea.setEditable(false);

        add(laptop);
        add(phone);
        add(headphones);
        add(billBtn);
        add(new JScrollPane(billArea));

        billBtn.addActionListener(e -> {
            int total = 0;
            StringBuilder items = new StringBuilder("Selected Items:\n");
            if (laptop.isSelected()) {
                items.append("Laptop - ₹").append(laptopPrice).append("\n");
                total += laptopPrice;
            }
            if (phone.isSelected()) {
                items.append("Phone - ₹").append(phonePrice).append("\n");
                total += phonePrice;
            }
            if (headphones.isSelected()) {
                items.append("Headphones - ₹").append(headphonesPrice).append("\n");
                total += headphonesPrice;
            }
            items.append("\nTotal Price: ₹").append(total);
            billArea.setText(items.toString());
        });

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ShoppingCart();
    }
}
