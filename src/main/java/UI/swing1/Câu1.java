/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package UI.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Câu1 extends JFrame {
    private JTextField textField;
    private JCheckBox boldCheckBox;
    private JCheckBox italicCheckBox;

    public Câu1() {
        setTitle("JCheckBox Test");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change");
        textField.setPreferredSize(new Dimension(350, 30));
        add(textField);

        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");

        add(boldCheckBox);
        add(italicCheckBox);

        // Thêm Action Listener cho JCheckBox
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateFont();
            }
        };

        boldCheckBox.addItemListener(itemListener);
        italicCheckBox.addItemListener(itemListener);
    }

    private void updateFont() {
        int style = Font.PLAIN;
        if (boldCheckBox.isSelected()) {
            style |= Font.BOLD;
        }
        if (italicCheckBox.isSelected()) {
            style |= Font.ITALIC;
        }
        textField.setFont(new Font("Serif", style, 14));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Câu1 frame = new Câu1();
            frame.setVisible(true);
        });
    }
}