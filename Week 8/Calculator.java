import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField text;
    String num = "", op = "";
    double n1 = 0;
    public Calculator() {
        setLayout(new BorderLayout());
        text = new JTextField();
        add(text, BorderLayout.NORTH);
        JPanel p = new JPanel(); p.setLayout(new GridLayout(4,4));
        String[] buttons = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        for(String b : buttons) {
            JButton btn = new JButton(b); btn.addActionListener(this); p.add(btn);
        }
        add(p);
        setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String t = e.getActionCommand();
        if(t.matches("\\d") || t.equals(".")) num += t;
        else if(t.equals("=")) {
            double n2 = Double.parseDouble(num);
            double r = 0;
            switch(op) {
                case "+": r = n1 + n2; break;
                case "-": r = n1 - n2; break;
                case "*": r = n1 * n2; break;
                case "/": r = n1 / n2; break;
            }
            text.setText("" + r);
            num = ""; op = "";
        } else {
            n1 = Double.parseDouble(num);
            op = t; num = "";
            text.setText("");
        }
        if(!t.equals("=") && !t.matches("[+\\-*/]")) text.setText(num);
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
