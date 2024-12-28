package UI.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class Câu7 extends JFrame {
    private JComboBox<String> imageComboBox;
    private final JLabel imageLabel;

    // Mảng tên file hình ảnh với phần mở rộng là .jpg
    private final String[] imageFiles = {
        "bug1.png",
        "bug2.png", // Đảm bảo rằng file này tồn tại
        "travelbug.png" // Đảm bảo rằng file này tồn tại
    };

    public Câu7() {
        setTitle("Testing JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 300);

        // Initialize JComboBox with image file names
        imageComboBox = new JComboBox<>(imageFiles);
        imageComboBox.setSelectedIndex(0); // Select the first image by default

        // Initialize JLabel to display the image
        imageLabel = new JLabel();
        displayImage(imageFiles[0]); // Display the first image

        // Add ActionListener to JComboBox
        imageComboBox.addActionListener((ActionEvent e) -> {
            String selectedImage = (String) imageComboBox.getSelectedItem();
            displayImage(selectedImage);
        });

        // Add components to the frame
        add(imageComboBox);
        add(imageLabel);

        setVisible(true);
    }
    
    private void displayImage(String imageName) {
        String path = "src/main/java/UI/images/" + imageName;
        System.out.println("Trying to load: " + path);

        ImageIcon imageIcon = new ImageIcon(path);
        if (imageIcon.getImageLoadStatus() == java.awt.MediaTracker.ERRORED) {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found: " + imageName);
        } else {
            // Resize the image
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            imageLabel.setIcon(new ImageIcon(resizedImage)); 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Câu7());
    }
}