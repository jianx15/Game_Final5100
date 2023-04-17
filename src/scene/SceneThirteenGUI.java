package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneThirteenGUI extends JPanel implements Scene, ActionListener {

    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;
    public SceneThirteenGUI(Character player, Utility utility) {
        text = "The Riddler is known for his unconventional approach to riddles and puzzles, always pushing the limits of creativity and intelligence. \n" +
                "Recently, he took things to a whole new level by using fireworks to display a Sudoku puzzle in the night sky. \n" +
                "With each explosion, a number would be revealed, slowly filling in the grid until the entire puzzle was complete. \n" +
                "It was a stunning display of both art and logic, leaving onlookers in awe of the Riddler's ingenuity. \n" +
                "As people tried to solve the puzzle, they couldn't help but wonder what other tricks the enigmatic villain had up his sleeve.\n" +
                "Whether you love him or hate him, there's no denying that the Riddler is a master of his craft, always finding new ways to challenge and entertain those who dare to try and solve his puzzles.\n\n\n";

        this.player = player;
        this.utility = utility;
        this.text += "0 0 0 0 0 0 0 0 0\n0 0 0 0 0 3 0 8 5\n0 0 1 0 2 0 0 0 0\n0 0 0 5 0 7 0 0 0\n0 0 4 0 0 0 1 0 0\n0 9 0 0 0 0 0 0 0\n5 0 0 0 0 0 0 7 3\n0 0 2 0 1 0 0 0 0\n0 0 0 0 4 0 0 0 9";


        optionsList = new ArrayList<>();
        optionsList.add("Ok I got my answer!");
        optionsList.add("Dang it's so hard. Bye, and Batman is smarter than you.");
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
            case "Ok I got my answer!":
                return new SceneFifteenGUI(this.player, this.utility);
            case "Dang it's so hard. Bye, and Batman is smarter than you.":
                return new SceneFourteenGUI(this.player, this.utility);
        }

        return null;
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
