package scene;

import dao.Character;
import dao.Weapon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneFiveGUI implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneFiveGUI(Character player, Utility utility) {
        text = "You choose to say...\n";

        this.player = player;
        this.utility = utility;

        optionsList = new ArrayList<>();
        optionsList.add("What's wrong with you?");
        optionsList.add("Sorry! Not looking for any trouble. (This will take you to the lake)");
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
            case "Sorry! Not looking for any trouble. (This will take you to the lake)":
                return new SceneTenGUI(this.player, this.utility);
        }
        return new SceneSixGUI(this.player, this.utility);
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
