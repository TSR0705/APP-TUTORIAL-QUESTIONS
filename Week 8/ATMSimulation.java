import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSimulation extends JFrame {
    private JPasswordField pinField;
    private JButton loginBtn, checkBtn, depositBtn, withdrawBtn;
    private JLabel statusLabel;
    private int balance = 10000;

    public ATMSimulation() {
        super("ATM Simulation");
        setLayout(new FlowLayout());

        add(new JLabel("Enter PIN:"));
        pinField = new JPasswordField(10);
        add(pinField);

        loginBtn = new JButton("Login");
        add(loginBtn);

        checkBtn = new JButton("Check Balance");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");

        checkBtn.setVisible(false);
        depositBtn.setVisible(false);
        withdrawBtn.setVisible(false);

        add(checkBtn);
        add(depositBtn);
        add(withdrawBtn);

        statusLabel = new JLabel("");
        add(statusLabel);

        loginBtn.addActionListener(e -> {
            String enteredPin = new String(pinField.getPassword());
            if (enteredPin.equals("1234")) {
                statusLabel.setText("Login successful!");
                checkBtn.setVisible(true);
                depositBtn.setVisible(true);
                withdrawBtn.setVisible(true);
                pinField.setEnabled(false);
                loginBtn.setEnabled(false);
            } else {
                statusLabel.setText("Incorrect PIN. Try again.");
            }
        });

        checkBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Balance: ₹" + balance);
        });

        depositBtn.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog(this, "Enter deposit amount:");
            try {
                int amount = Integer.parseInt(amountStr);
                if (amount > 0) {
                    balance += amount;
                    JOptionPane.showMessageDialog(this, "Deposit successful. New balance: ₹" + balance);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount");
            }
        });

        withdrawBtn.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog(this, "Enter withdrawal amount:");
            try {
                int amount = Integer.parseInt(amountStr);
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this, "Withdrawal successful. New balance: ₹" + balance);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient balance or invalid amount");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount");
            }
        });

        setSize(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ATMSimulation();
    }
}
