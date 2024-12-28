package UI.swing1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;

public class Câu5 extends JFrame {
    private JLabel lblSelectedDay;
    private JList<String> lstDays;

    public Câu5() {
        // Thiết lập JFrame
        setTitle("ListDemo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(230, 170);
        setLayout(new BorderLayout());

        // Tạo JLabel hiển thị dòng được chọn
        lblSelectedDay = new JLabel("Sunday", SwingConstants.CENTER); 
        lblSelectedDay.setOpaque(true); 
        lblSelectedDay.setBackground(Color.PINK);
        lblSelectedDay.setForeground(Color.BLACK);
        lblSelectedDay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(lblSelectedDay, BorderLayout.NORTH);

        // Tạo JList chứa các ngày trong tuần
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        lstDays = new JList<>(days);
        lstDays.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstDays.setSelectedIndex(0); 
        lstDays.addListSelectionListener(e -> {
            
            if (!e.getValueIsAdjusting()) {
                lblSelectedDay.setText(lstDays.getSelectedValue());
            }
        });
        add(new JScrollPane(lstDays), BorderLayout.CENTER);

        // Hiển thị JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Câu5();
    }
}

