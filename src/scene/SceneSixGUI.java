package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneSixGUI implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;
    private Character enemy;

    public SceneSixGUI(Character player, Utility utility) {
        this.player = player;
        this.utility = utility;
        this.enemy = utility.findCharacter("Bob");
        text = this.enemy.getName() + "is drawn to a fight...\n"
        + "\n"
        + this.enemy.getName() + "'s HP is " + this.enemy.getHealth()
        + "\n"
        + this.player.getName() + "'s HP is " + this.player.getHealth()
        + "\n\n\n"
        + this.enemy.getName() + " hits " + this.player.getName() + " and cause " + this.enemy.getDamage() + " damage!"
        + "\n"
        + "What do you want to do?";

        optionsList = new ArrayList<>();
        optionsList.add("Attack");
        optionsList.add("Take Meds");
    }

    public SceneSixGUI(Character player, Utility utility, Character enemy) {
        this.player = player;
        this.utility = utility;
        this.enemy = enemy;
        text = this.enemy.getName() + "is drawn to a fight...\n"
                + "\n"
                + this.enemy.getName() + "'s HP is " + this.enemy.getHealth()
                + "\n"
                + this.player.getName() + "'s HP is " + this.player.getHealth()
                + "\n\n\n"
                + this.enemy.getName() + " hits " + this.player.getName() + " and cause " + this.enemy.getDamage() + " damage!"
                + "\n"
                + "What do you want to do?";

        optionsList = new ArrayList<>();
        optionsList.add("Attack");
        optionsList.add("Take Meds");
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
        this.player.healthChange(-this.enemy.getDamage());
        if ("Attack".equals(this.option)) {
            this.enemy.healthChange(-this.player.getDamage());
            if (this.enemy.getHealth() <= 0) {
                return new SceneSevenGUI(this.player, this.utility);
            } else if (this.player.getHealth() <= 0) {
                return new SceneNineGUI(this.player, this.utility);
            }
            return new SceneSixGUI(this.player, this.utility);
        }

        if (this.player.getHealth() <= 0) {
            return new SceneNineGUI(this.player, this.utility);
        }
        return new SceneEightGUI(this.player, this.utility, this.enemy);
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
