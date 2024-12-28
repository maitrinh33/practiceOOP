package UI.swing1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Câu11 extends JFrame {
    private final JTextField accountNumberField;
    private final JTextField accountNameField;
    private final JTextField accountMoneyField;
    private final JTable accountTable;
    private final DefaultTableModel tableModel;

    public Câu11() {
        setTitle("Account Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        inputPanel.add(accountNumberField);

        inputPanel.add(new JLabel("Account Name:"));
        accountNameField = new JTextField();
        inputPanel.add(accountNameField);

        inputPanel.add(new JLabel("Account Money:"));
        accountMoneyField = new JTextField();
        inputPanel.add(accountMoneyField);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying accounts
        tableModel = new DefaultTableModel(new String[]{"Acc Number", "Acc Name", "Acc Money"}, 0);
        accountTable = new JTable(tableModel);
        add(new JScrollPane(accountTable), BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        addButton.addActionListener((ActionEvent e) -> {
            addAccount();
        });

        clearButton.addActionListener((ActionEvent e) -> {
            clearFields();
        });

        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void addAccount() {
        String accNumber = accountNumberField.getText();
        String accName = accountNameField.getText();
        String accMoney = accountMoneyField.getText();

        if (!accNumber.isEmpty() && !accName.isEmpty() && !accMoney.isEmpty()) {
            tableModel.addRow(new Object[]{accNumber, accName, accMoney});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        accountNumberField.setText("");
        accountNameField.setText("");
        accountMoneyField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Câu11::new);
    }
}