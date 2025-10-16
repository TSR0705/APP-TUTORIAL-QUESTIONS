import javax.swing.*;

public class FeedbackForm extends JFrame {
    JRadioButton[] stars;
    ButtonGroup group;
    JTextArea comment;
    JButton submit;

    public FeedbackForm() {
        setLayout(null);
        stars = new JRadioButton[5];
        group = new ButtonGroup();
        int x = 20;
        for(int i=0;i<5;i++) {
            stars[i] = new JRadioButton((i+1) + " Star");
            stars[i].setBounds(x,20,80,30);
            add(stars[i]); group.add(stars[i]); x += 90;
        }
        comment = new JTextArea(); comment.setBounds(20,60,350,80);
        submit = new JButton("Submit"); submit.setBounds(20,150,100,30);
        add(comment); add(submit);

        submit.addActionListener(e -> JOptionPane.showMessageDialog(this, "Thank you for your feedback!"));

        setSize(410,250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new FeedbackForm();
    }
}
