package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneTwelveGUI extends JPanel implements Scene, ActionListener {

    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneTwelveGUI(Character player, Utility utility) {
        text = "You choose to…\n\n\n";
        this.player = player;
        this.utility = utility;

        optionsList = new ArrayList<>();
        optionsList.add("Ok! I am the smartest man on Earth.");
        optionsList.add("No, because my mom doesn’t let me play with jerks.");
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<String> getOptionList() {
        return optionsList;
    }

    @Override
    public Scene proceed(Scene scene) {
        switch (this.option) {
            case "Ok! I am the smartest man on Earth.":
                return new SceneThirteenGUI(this.player, this.utility);
            case "No, because my mom doesn’t let me play with jerks.":
                return new SceneFourteenGUI(this.player, this.utility);
        }
        return scene;
    }

    @Override
    public void setOption(String option) {
        this.option = option;
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
