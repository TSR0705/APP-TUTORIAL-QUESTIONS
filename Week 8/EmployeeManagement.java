import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagement extends JFrame {
    private JTextField nameField, deptField, salaryField;
    private JButton addBtn;
    private JTable table;
    private DefaultTableModel tableModel;

    public EmployeeManagement() {
        super("Employee Management");
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        addBtn = new JButton("Add Employee");
        inputPanel.add(addBtn);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"Name", "Department", "Salary"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String dept = deptField.getText();
            String salary = salaryField.getText();

            if (!name.isEmpty() && !dept.isEmpty() && !salary.isEmpty()) {
                tableModel.addRow(new Object[]{name, dept, salary});
                nameField.setText("");
                deptField.setText("");
                salaryField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "All fields are required!");
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeManagement();
    }
}
