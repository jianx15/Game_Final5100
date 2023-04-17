import dao.Character;
import scene.Scene;
import scene.SceneOneGUI;
import scene.Utility;

import javax.swing.*;

public class GameEngine {
    private Scene currentScene;

    private Character player;

    private Utility utility;

    public GameEngine(Character player, Utility utility) {
        // Initialize the game by setting the first scene
        this.currentScene = new SceneOneGUI(player, utility);
        this.player = player;
        this.utility = utility;
    }

    public void start() {
        JFrame frame = new JFrame("Gothem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel(currentScene);
        frame.getContentPane().add(gamePanel);

        frame.pack();
        frame.setVisible(true);
    }
}
