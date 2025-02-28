import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.*;

public class StudentGrading {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Grading System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("Student Grading System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(160, 20, 400, 30);

        // Name Label & Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setBounds(100, 80, 100, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 80, 250, 25);
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        nameField.setForeground(Color.BLACK);
        nameField.setBorder(BorderFactory.createEmptyBorder()); // Border hataya

        // Name field input limit
        nameField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) return;
                if ((getLength() + str.length()) <= 20) { // Limit to 20 characters
                    super.insertString(offs, str, a);
                }
            }
        });

        // Marks Label & Field
        JLabel marksLabel = new JLabel("Marks (0-100):");
        marksLabel.setForeground(Color.WHITE);
        marksLabel.setFont(new Font("Arial", Font.BOLD, 16));
        marksLabel.setBounds(100, 120, 150, 25);

        JTextField marksField = new JTextField();
        marksField.setBounds(250, 120, 200, 25);
        marksField.setFont(new Font("Arial", Font.BOLD, 14)); // Bold text
        marksField.setForeground(Color.BLACK); // Black text
        marksField.setBorder(BorderFactory.createEmptyBorder()); // Border hataya

        // Buttons
        JButton calculateButton = new JButton("Calculate Grade");
        calculateButton.setBounds(80, 180, 150, 40);
        calculateButton.setBackground(new Color(135, 206, 250));
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(250, 180, 120, 40);
        resetButton.setBackground(new Color(255, 200, 150));
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(390, 180, 120, 40);
        exitButton.setBackground(new Color(255, 120, 120));
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Result Labels
        JLabel gradeLabel = new JLabel("Grade: -");
        gradeLabel.setForeground(Color.YELLOW);
        gradeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gradeLabel.setBounds(100, 250, 200, 25);

        JLabel percentageLabel = new JLabel("Percentage: -");
        percentageLabel.setForeground(Color.YELLOW);
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        percentageLabel.setBounds(100, 280, 200, 25);

        JLabel statusLabel = new JLabel("Status: -");
        statusLabel.setForeground(Color.YELLOW);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setBounds(100, 310, 200, 25);

        // Action Listeners
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int marks = Integer.parseInt(marksField.getText());
                    if (marks < 0 || marks > 100) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid marks (0-100).", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String grade;
                    if (marks >= 90) grade = "A+";
                    else if (marks >= 80) grade = "A";
                    else if (marks >= 70) grade = "B";
                    else if (marks >= 60) grade = "C";
                    else if (marks >= 50) grade = "D";
                    else grade = "F";

                    gradeLabel.setText("Grade: " + grade);
                    percentageLabel.setText("Percentage: " + marks + "%");
                    statusLabel.setText("Status: " + (marks >= 50 ? "Pass" : "Fail"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for marks.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                marksField.setText("");
                gradeLabel.setText("Grade: -");
                percentageLabel.setText("Percentage: -");
                statusLabel.setText("Status: -");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        // Background Panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 400);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);

        // Adding Components
        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(marksLabel);
        panel.add(marksField);
        panel.add(calculateButton);
        panel.add(resetButton);
        panel.add(exitButton);
        panel.add(gradeLabel);
        panel.add(percentageLabel);

         panel.add(statusLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
