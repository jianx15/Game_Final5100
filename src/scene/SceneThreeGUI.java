package scene;

import dao.Character;
import dao.Inventory;
import dao.Weapon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SceneThreeGUI implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;


    public SceneThreeGUI(Character player, Utility utility) {
        text = "There are 3 weapons on the grass " + player + "\n"
        + "\n"
        + "Which one do you want to pick up?";

        this.player = player;
        this.utility = utility;

        optionsList = new ArrayList<>();
        optionsList.add("Sword (Attack damage + 50)");
        optionsList.add("Axe (Attack damage + 75)");
        optionsList.add("Great Sword (Attack damage + 60)");
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
        Inventory inventory = this.player.getInventory();
        switch (this.option) {
            case "Sword (Attack damage + 50)":
                Weapon sword = utility.findWeapon("Sword");
                inventory.addWeapon(sword);
                this.player.wear(sword);
                break;

            case "Axe (Attack damage + 75)":
                Weapon axe = utility.findWeapon("Axe");
                inventory.addWeapon(axe);
                this.player.wear(axe);
                break;

            case "Great Sword (Attack damage + 60)":
                Weapon greatSword = utility.findWeapon("Great Sword");
                inventory.addWeapon(greatSword);
                this.player.wear(greatSword);
                break;
        }

        System.out.println(this.player.getName() + " have selected " + this.player.getInventory().getMainWeapon().getName());
        System.out.println(this.player.getName() + "'s current damage is " + this.player.getDamage());

        return new SceneFourGUI(this.player, this.utility);
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
