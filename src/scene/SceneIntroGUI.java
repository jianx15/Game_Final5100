package scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneIntroGUI extends JFrame implements ActionListener {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JButton startButton;
    private String username;
    public SceneIntroGUI() {
        setTitle("Welcome to the Game!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 3));

        nameLabel = new JLabel("Please enter your name:");
        nameTextField = new JTextField();
        startButton = new JButton("Start Game");
        startButton.addActionListener(this);

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(startButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true); // set visibility to true
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            String playerName = nameTextField.getText().trim();
            this.username = playerName;
            if (!playerName.isEmpty()) {
                dispose(); // close the JFrame
            }
        }
    }

    public String getUsername() {
        return this.username;
    }
}
