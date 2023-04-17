package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SceneOneGUI extends JPanel implements Scene, ActionListener {
    private String text;
    private boolean proceed;
    private Character player;
    private Utility utility;

    public SceneOneGUI(Character player, Utility utility) {
        this.player = player;
        this.utility = utility;

        text = "Hi " + player.getName() + "! Welcome to Gothem\n" +
            "\n" +
            "NOW you have entered Forest… It is misty and dark.\n" +
            "\n" +
            "Suddenly, you see a muscle-bound madman with intimidating mask.\n" +
            "\n" +
            "You are scared, but you have no choice other than asking this this weird man for help. \n" +
            "\n" +
            "Luckily, you look around and found a bunch of weapons scattered around, not knowing who left behind. \n";
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<String> getOptionList() {
        return List.of("Proceed");
    }

    @Override
    public Scene proceed(Scene scene) {
        if (this.proceed) {
            return new SceneTwoGUI(this.player, this.utility);
        }
        return scene;
    }

    @Override
    public void setOption(String option) {
        this.proceed = true;
    }

    @Override
    public boolean isEndScene() {
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        setOption(button.getText());
    }
}
