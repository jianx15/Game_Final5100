package scene;

import dao.Character;
import dao.Medicine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneEightGUI implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;

    private Character enemy;
    private Utility utility;

    public SceneEightGUI(Character player, Utility utility, Character enemy) {
        this.player = player;
        this.utility = utility;
        this.enemy = enemy;
        text = "Let's take a look at " + this.player.getName() + "'s bag "
        + "\n";

        optionsList = new ArrayList<>();
        for (Medicine medicine : this.player.getInventory().getMedicines()) {
            optionsList.add(medicine.getName() + " (" + medicine.describe() + ")");
        }

        if (optionsList.size() == 0) {
            optionsList.add("Oh no you are out of meds!!!");
        }
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
        Medicine medicineToBeUsed = null;
        for (Medicine medicine : this.player.getInventory().getMedicines()) {
            if (this.option.contains(medicine.getName())) {
                this.player.healthChange(medicine.getHealAmount());
                medicineToBeUsed = medicine;
            }
        }

        this.player.getInventory().getMedicines().remove(medicineToBeUsed);
        return new SceneSixGUI(this.player, this.utility, this.enemy);
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
