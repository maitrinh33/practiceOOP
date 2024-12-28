package UI.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Câu9 extends JFrame {
    private final DefaultListModel<Integer> listModel;
    private final JList<Integer> numberList;
    private final JTextField inputField;
    private final JCheckBox allowNegativeCheckBox;

    public Câu9() {
        setTitle("Thao tác trên JList - Checkbox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the list model and JList
        listModel = new DefaultListModel<>();
        numberList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(numberList);
        listScrollPane.setPreferredSize(new Dimension(200, 250));

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input field
        inputField = new JTextField(6);
        inputPanel.add(new JLabel("Nhập thông tin:"));
        inputPanel.add(inputField);

        // Create button to add numbers
        JButton addButton = new JButton("Nhập");
        inputPanel.add(addButton);

        // Create checkbox for allowing negative numbers
        allowNegativeCheckBox = new JCheckBox("Cho nhập số âm");
        inputPanel.add(allowNegativeCheckBox);

        // Create task panel with buttons
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(7, 1));

        JButton evenButton = new JButton("Tô đen số chẵn");
        JButton oddButton = new JButton("Tô đen số lẻ");
        JButton primeButton = new JButton("Tô đen số nguyên tố");
        JButton removeHighlightedButton = new JButton("Xóa các giá trị đang tô đen");
        JButton sumButton = new JButton("Tổng giá trị trong JList");
        JButton clearHighlightButton = new JButton("Bỏ tô đen");
        JButton closeButton = new JButton("Đóng chương trình");

        taskPanel.add(evenButton);
        taskPanel.add(oddButton);
        taskPanel.add(primeButton);
        taskPanel.add(removeHighlightedButton);
        taskPanel.add(sumButton);
        taskPanel.add(clearHighlightButton);
        taskPanel.add(closeButton);

        // Add action listeners
        addButton.addActionListener(new AddNumberListener());
        evenButton.addActionListener(e -> highlightEvenNumbers());
        oddButton.addActionListener(e -> highlightOddNumbers());
        primeButton.addActionListener(e -> highlightPrimeNumbers());
        removeHighlightedButton.addActionListener(e -> removeHighlightedNumbers());
        sumButton.addActionListener(e -> calculateSum());
        clearHighlightButton.addActionListener(e -> clearHighlight());
        closeButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng chương trình?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Adding components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.CENTER);
        add(taskPanel, BorderLayout.EAST);

        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private class AddNumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = inputField.getText().trim();
            try {
                int number = Integer.parseInt(inputText);

                // Check if negative numbers are allowed
                if (number < 0 && !allowNegativeCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(Câu9.this, "Không cho phép nhập số âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    listModel.addElement(number);
                    inputField.setText(""); // Clear input field
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Câu9.this, "Vui lòng nhập một số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void highlightEvenNumbers() {
        highlightNumbers(n -> n % 2 == 0);
    }

    private void highlightOddNumbers() {
        highlightNumbers(n -> n % 2 != 0);
    }

    private void highlightPrimeNumbers() {
        highlightNumbers(this::isPrime);
    }

    private void highlightNumbers(java.util.function.IntPredicate predicate) {
        numberList.clearSelection();
        for (int i = 0; i < listModel.size(); i++) {
            if (predicate.test(listModel.get(i))) {
                numberList.addSelectionInterval(i, i);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private void removeHighlightedNumbers() {
        int[] selectedIndices = numberList.getSelectedIndices();
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            listModel.remove(selectedIndices[i]);
        }
        clearHighlight();
    }

    private void calculateSum() {
        int sum = 0;
        for (int i = 0; i < listModel.size(); i++) {
            sum += listModel.get(i);
        }
        JOptionPane.showMessageDialog(this, "Tổng giá trị trong JList là: " + sum);
    }

    private void clearHighlight() {
        numberList.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Câu9::new);
    }
}