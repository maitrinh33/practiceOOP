package UI.swing1;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

public class Câu6 extends JFrame {
    private final JList<String> jListLeft;
    private final JList<String> jListRight;
    private final DefaultListModel<String> listModelLeft;
    private final DefaultListModel<String> listModelRight;
    private JButton btnCopy;
    private final JMenuBar menuBar;
    private final JMenu menu;
    private final JMenuItem menuSave;
    private final JMenuItem menuClose;
    private final JMenuItem menuCopy;

    public Câu6() {
        // Setup the UI
        setTitle("Multiple Selection Lists");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(440, 300);
        setLayout(null);

        listModelLeft = new DefaultListModel<>();
        listModelRight = new DefaultListModel<>();

        jListLeft = new JList<>(listModelLeft);
        jListRight = new JList<>(listModelRight);

        // Enable multiple selection in the left JList
        jListLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollLeft = new JScrollPane(jListLeft);
        JScrollPane scrollRight = new JScrollPane(jListRight);

        btnCopy = new JButton("Copy >>>");

        menuBar = new JMenuBar();
        menu = new JMenu("MENU 🡇 ");
        menuSave = new JMenuItem("1. Save");
        menuClose = new JMenuItem("2. Close");
        menuCopy = new JMenuItem("3. Copy");

        // Load data from file
        loadDataFromFile("src/main/java/UI/swing1/data.txt");

        
        JLabel instructionLabel = new JLabel("Hold the Ctrl key (Command key on macOS) to select more items");
        instructionLabel.setBounds(20, 5, 400, 20); 
        
        scrollLeft.setBounds(20, 30, 120, 200);
        btnCopy.setBounds(150, 100, 100, 30);
        scrollRight.setBounds(270, 30, 120, 200);

        menu.add(menuSave);
        menu.add(menuClose);
        menu.add(menuCopy);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        
        add(instructionLabel); 
        add(scrollLeft);
        add(btnCopy);
        add(scrollRight);

        // Handle Copy button
        btnCopy.addActionListener(e -> copySelectedItems());

        // Menu Save
        menuSave.addActionListener(e -> saveToFile());

        // Menu Close
        menuClose.addActionListener(e -> {
            saveToFile();
            System.exit(0);
        });

        // Menu Copy
        menuCopy.addActionListener(e -> btnCopy.doClick());

        // Save file when closing the application
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveToFile();
                System.exit(0);
            }
        });
    }

    private void loadDataFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                listModelLeft.addElement(line);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void copySelectedItems() {
        List<String> selectedValues = jListLeft.getSelectedValuesList();
        for (String value : selectedValues) {
            if (!listModelRight.contains(value)) {
                listModelRight.addElement(value);
            }
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/UI/swing1/output.txt"))) {
            for (int i = 0; i < listModelRight.size(); i++) {
                bw.write(listModelRight.get(i));
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Data saved successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Câu6().setVisible(true);
        });
    }
}