import javax.swing.*;
import java.awt.*;

public class Runner {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(100, 100);
        String[] items = new String[]{"Car", "dog", "cat", "train", "plum", "cute", "pie", "egg", "ham", "tan", "blam", "can", "lorum", "ipsum"
                , "dora", "india", "egyt", "norway", "norse", "gods", "goose", "echo", "elderly", "me"};

        SuggestionField sf = new SuggestionField();

        JPanel panel = new JPanel();

        sf.setValues(items);

        panel.setLayout(new GridLayout(1,1));
        panel.add(sf);
        frame.add(panel);

        frame.setVisible(true);

    }
}
