/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.swing1;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Câu10 extends JFrame {
    private final JPanel colorPanel;
    private final JSlider redSlider;
    private final JSlider greenSlider;
    private final JSlider blueSlider;

    public Câu10() {
        setTitle("View Colors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the color panel
        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(300, 300));
        colorPanel.setBackground(new Color(187, 69, 255)); // Initial color
        add(colorPanel, BorderLayout.CENTER);

        // Create sliders for Red, Green, and Blue
        redSlider = createColorSlider("Red");
        greenSlider = createColorSlider("Green");
        blueSlider = createColorSlider("Blue");

        // Create panel for sliders
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.add(redSlider);
        sliderPanel.add(greenSlider);
        sliderPanel.add(blueSlider);

        // Add slider panel to the frame
        add(sliderPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private JSlider createColorSlider(String colorName) {
        JSlider slider = new JSlider(0, 255);
        slider.setValue(0);
        slider.setMajorTickSpacing(51);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateColor();
            }
        });
        return slider;
    }

    private void updateColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        colorPanel.setBackground(new Color(red, green, blue));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Câu10::new);
    }
}
