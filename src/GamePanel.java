import scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private Scene currentScene;
    private JTextArea sceneTextArea;
    private JPanel optionsPanel;
    private boolean gameRunning;

    public GamePanel(Scene initialScene) {
        currentScene = initialScene;
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());

        // Create the text area for displaying the scene text
        sceneTextArea = new JTextArea(currentScene.getText());
        sceneTextArea.setEditable(false);
        sceneTextArea.setLineWrap(true);
        sceneTextArea.setWrapStyleWord(true);
        add(sceneTextArea, BorderLayout.CENTER);

        // Create the panel for displaying the options as buttons
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(0, 1));
        add(optionsPanel, BorderLayout.SOUTH);

        gameRunning = true;
        updateScene(currentScene);
    }

    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            if (e.getSource() instanceof JButton) {
                String selectedOption = ((JButton) e.getSource()).getText();
                currentScene.setOption(selectedOption);
                currentScene = currentScene.proceed(currentScene);
                updateScene(currentScene);
            }
        } else {
            //close panel
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        }
    }

    public void updateScene(Scene scene) {
        sceneTextArea.setText(scene.getText());
        optionsPanel.removeAll();
        List<String> options = scene.getOptionList();
        for (String option : options) {
            JButton optionButton = new JButton(option);
            optionButton.addActionListener(this);
            optionsPanel.add(optionButton);
        }
        if (options.size() == 1) {
            optionsPanel.getComponent(0).requestFocusInWindow();
        }
        revalidate();
        repaint();

        if (scene.isEndScene()) {
            gameRunning = false;
        }
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
        updateScene(currentScene);
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
}
