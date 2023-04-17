package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneElevenGUI extends JPanel implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneElevenGUI(Character player, Utility utility) {
        text = "Riddler sure appears to be more friendly. \n" +
                "\n" +
                "As you approach, Riddler sees you and actually talks to you before you could talk to him.\n" +
                "\n" +
                "He says:\n" +
                "\n" +
                "“Hi! You look nerdy. Do you want to play Sudoku with me?”\n";

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
        return new SceneTwelveGUI(this.player, this.utility);
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
