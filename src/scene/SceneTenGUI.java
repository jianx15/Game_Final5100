package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneTenGUI extends JPanel implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneTenGUI(Character player, Utility utility) {
        text = "After you encountered with Bane with your knife until he passed out, you were really scared and ran away as fast as you could. \n" +
                "\n" +
                "You kept running until you were out of breath and stopped at a lake. \n" +
                "\n" +
                "There you saw a man with a bald head wearing a green outfit with a question mark on his forehead. It was the Riddler! \n" +
                "\n" +
                "You were glad he didn't seem like he would punch you. After you caught your breath, you decided to talk to him and have some fun.\n";
        this.player = player;
        this.utility = utility;

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
        return new SceneElevenGUI(this.player, this.utility);
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
