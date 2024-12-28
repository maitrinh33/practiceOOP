/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.swing1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Câu12 extends JFrame {
    private final JLabel imageLabel;
    private final JButton startButton;
    private final JButton stopButton;
    private Timer timer;
    private int currentImageIndex = 0;

    // Array of image paths (Update these paths to your local images)
    private final String[] imagePaths = {
        "src/main/java/UI/images/image1.jpg",
        "src/main/java/UI/images/image2.jpg",
        "src/main/java/UI/images/image3.jpg",
        "src/main/java/UI/images/image4.jpg",
        "src/main/java/UI/images/image5.jpg",
        "src/main/java/UI/images/image6.jpg",
        "src/main/java/UI/images/image7.jpg",
        "src/main/java/UI/images/image8.jpg",
        "src/main/java/UI/images/image9.jpg",
        "src/main/java/UI/images/image10.jpg"
    };

    public Câu12() {
        setTitle("Image Animation"); 
        setSize(new Dimension(800, 600)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create label to display images
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Create buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up Timer
        timer = new Timer(1000, (ActionEvent e) -> {
            displayNextImage();
        });

        // Button action listeners
        startButton.addActionListener((ActionEvent e) -> {
            timer.start();
        });

        stopButton.addActionListener((ActionEvent e) -> {
            timer.stop();
        });

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void displayNextImage() {
        if (currentImageIndex >= imagePaths.length) {
            currentImageIndex = 0; 
        }
        ImageIcon imageIcon = new ImageIcon(imagePaths[currentImageIndex]);
        imageLabel.setIcon(imageIcon);
        currentImageIndex++;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Câu12::new);
    }
}
