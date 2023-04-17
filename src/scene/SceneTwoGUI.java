package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneTwoGUI extends JPanel implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneTwoGUI(Character player, Utility utility) {
        text = "You choose to…\n";
        this.player = player;
        this.utility = utility;

        optionsList = new ArrayList<>();
        optionsList.add("Go straight to the weird man");
        optionsList.add("Pick up the weapon first");
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
            case "Go straight to the weird man":
                return new SceneFourGUI(this.player, this.utility);
            case "Pick up the weapon first":
                return new SceneThreeGUI(this.player, this.utility);
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
