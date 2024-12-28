package UI.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Câu8 extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JTextField inputField;

    public Câu8() {
        setTitle("List Edit Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the list model and JList
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(itemList);
        
        // Set preferred size for the JList within the scroll pane
        listScrollPane.setPreferredSize(new Dimension(200, 250)); // Adjust size here if needed
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        
        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for the input panel
        
        // Create label
        JLabel label = new JLabel("Input Name:");
        inputPanel.add(label); // Add label to input panel
        
        // Create text field with smaller preferred size
        inputField = new JTextField(30); 
        inputField.setPreferredSize(new Dimension(360, 25)); 
        inputPanel.add(inputField); 

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Use FlowLayout for buttons
        
        // Create buttons with smaller preferred size
        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Remove Item");
        JButton editButton = new JButton("Edit Item");

        Dimension buttonSize = new Dimension(120, 25);
        addButton.setPreferredSize(buttonSize);
        removeButton.setPreferredSize(buttonSize);
        editButton.setPreferredSize(buttonSize);

        // Add buttons to the button panel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        // Add components to frame
        inputPanel.add(buttonPanel); // Add button panel to input panel
        add(listScrollPane, BorderLayout.WEST); // JList on the left
        add(inputPanel, BorderLayout.CENTER); // Input panel in the center

        // Add action listeners
        addButton.addActionListener(new AddItemListener());
        removeButton.addActionListener(new RemoveItemListener());
        editButton.addActionListener(new EditItemListener());
        itemList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && itemList.getSelectedValue() != null) {
                inputField.setText(itemList.getSelectedValue());
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    private class AddItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = inputField.getText().trim();
            if (inputText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (listModel.contains(inputText)) {
                JOptionPane.showMessageDialog(null, "Item already exists.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                listModel.addElement(inputText);
                inputField.setText(""); // Clear input field
            }
        }
    }

    private class RemoveItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = itemList.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Please select an item to remove.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this item?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    listModel.remove(selectedIndex);
                }
            }
        }
    }

    private class EditItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = itemList.getSelectedIndex();
            String inputText = inputField.getText().trim();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Please select an item to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (inputText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                listModel.set(selectedIndex, inputText);
                inputField.setText(""); // Clear input field
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Câu8::new);
    }
}