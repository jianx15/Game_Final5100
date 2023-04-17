package scene;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Scene {

    public String getText();

    public List<String> getOptionList();

    public Scene proceed(Scene scene);

    public void setOption(String option);

    public boolean isEndScene();
}
