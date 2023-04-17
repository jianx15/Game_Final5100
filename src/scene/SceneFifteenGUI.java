package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneFifteenGUI extends JPanel implements Scene, ActionListener {
    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;

    public SceneFifteenGUI(Character player, Utility utility) {
        this.player = player;
        this.utility = utility;
        text = "The answer is \n\n\n";
        text += "9 8 7 6 5 4 3 2 1\n2 4 6 1 7 3 9 8 5\n3 5 1 9 2 8 7 4 6\n1 2 8 5 3 7 4 9 6\n7 6 4 8 9 2 1 5 3\n4 9 5 3 6 1 8 7 2\n5 1 9 4 8 6 2 7 3\n8 7 2 0 1 5 6 3 4\n6 3 0 0 4 0 5 1 9";

        optionsList = new ArrayList<>();
        optionsList.add("End");
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
        return null;
    }

    @Override
    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public boolean isEndScene() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        setOption(button.getText());
    }
}
