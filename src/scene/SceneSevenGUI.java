package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneSevenGUI implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneSevenGUI(Character player, Utility utility) {
        this.player = player;
        this.utility = utility;
        text = this.player.getName() + " successfully win the battle!\n";

        optionsList = new ArrayList<>();
        optionsList.add("Proceed");
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
        return new SceneTenGUI(this.player, this.utility);
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
