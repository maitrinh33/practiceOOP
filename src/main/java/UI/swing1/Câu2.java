/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Câu2 extends JFrame {
    private JTextField textField;
    private JRadioButton plainButton;
    private JRadioButton boldButton;
    private JRadioButton italicButton;
    private JRadioButton boldItalicButton;
    private ButtonGroup group;

    public Câu2() {
        setTitle("RadioButton Test");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change");
        textField.setPreferredSize(new Dimension(350, 30));
        add(textField);

        plainButton = new JRadioButton("Plain");
        boldButton = new JRadioButton("Bold");
        italicButton = new JRadioButton("Italic");
        boldItalicButton = new JRadioButton("BoldItalic");

        // Thiết lập ButtonGroup
        group = new ButtonGroup();
        group.add(plainButton);
        group.add(boldButton);
        group.add(italicButton);
        group.add(boldItalicButton);

        add(plainButton);
        add(boldButton);
        add(italicButton);
        add(boldItalicButton);

        // Thêm Action Listener cho JRadioButtons
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFont();
            }
        };

        plainButton.addActionListener(actionListener);
        boldButton.addActionListener(actionListener);
        italicButton.addActionListener(actionListener);
        boldItalicButton.addActionListener(actionListener);

        // Mặc định chọn Plain
        plainButton.setSelected(true);
    }

    private void updateFont() {
        int style = Font.PLAIN;
        if (boldButton.isSelected()) {
            style = Font.BOLD;
        } else if (italicButton.isSelected()) {
            style = Font.ITALIC;
        } else if (boldItalicButton.isSelected()) {
            style = Font.BOLD | Font.ITALIC;
        }
        textField.setFont(new Font("Serif", style, 14));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Câu2 frame = new Câu2();
            frame.setVisible(true);
        });
    }
}
