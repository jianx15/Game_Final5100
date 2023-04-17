package scene;

import dao.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SceneFourGUI implements Scene, ActionListener {

    private String text;
    private List<String> optionsList;
    private String option;
    private Character player;
    private Utility utility;


    public SceneFourGUI(Character player, Utility utility) {
        text = "As you approach, you discover that it is Bane, the infamous villain of Gotham City, known for his voice that could shake the very foundations of the city. He is sitting next to a campfire, baking an apple.\n" +
                "\n" +
                "Your intrusion seems to irritate his enjoyment of the spring night, and he looks down at you with anger. He stares at you for a while, and with a volume that shakes the earth:\n" +
                "\n" +
                "\"What are you looking at?\"\n";

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
        return new SceneFiveGUI(this.player, this.utility);
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
