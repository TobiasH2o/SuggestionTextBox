import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SuggestionField extends JTextField implements DocumentListener, KeyListener {

    String[] values = new String[0];
    ArrayList<String> displayValues = new ArrayList<>(0);
    JFrame suggestionFrame = new JFrame();
    JPanel suggestionPanel = new JPanel();
    Color backGround = new Color(109, 104, 104, 133);
    Color selectBackGround = new Color(109, 104, 104, 133);
    Color textColor = new Color(5, 19, 88, 255);
    Color selectTextColor = new Color(115, 134, 238, 255);
    BoxLayout bl = new BoxLayout(suggestionPanel, BoxLayout.Y_AXIS);
    int selectedEntry = 0;

    public SuggestionField() {
        this.getDocument().addDocumentListener(this);
        this.addKeyListener(this);
        suggestionFrame.add(suggestionPanel);
        suggestionFrame.setUndecorated(true);
        suggestionFrame.setAlwaysOnTop(true);
        bl.maximumLayoutSize(suggestionPanel);
    }

    public void setValues(String[] values) {
        this.values = values.clone();
        for (int i = 0;i < values.length;i++) {
            this.values[i] = values[i].toUpperCase();
        }
        Arrays.sort(this.values);
    }

    public boolean updateSuggestions() {
        boolean added = false;
        boolean add = true;
        displayValues.clear();
        for (int i = 0;i < values.length;i++) {
            add = true;
            for (int k = 0;k < this.getText().length();k++) {
                if (values[i].toUpperCase().charAt(k) != this.getText().toUpperCase().charAt(k)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                added = true;
                displayValues.add(values[i]);
                if(values[i].equalsIgnoreCase(this.getText())){
                    added = false;
                    break;
                }
            }
        }
        return added;
    }

    private void updateDisplay() {

        suggestionFrame.setSize(this.getWidth(), 16 * displayValues.size());
        suggestionPanel.removeAll();
        suggestionPanel.setLayout(new BoxLayout(suggestionPanel, BoxLayout.Y_AXIS));
        for (int i = 0;i < displayValues.size();i++) {
            JLabel a = new JLabel(displayValues.get(i));
            if(i == selectedEntry){
                a.setBackground(selectBackGround);
                a.setForeground(selectTextColor);
            }else {
                a.setBackground(backGround);
                a.setForeground(textColor);
            }
            suggestionPanel.add(a);
        }
        suggestionPanel.revalidate();
        suggestionFrame.revalidate();
        suggestionFrame.setLocationRelativeTo(this);
        suggestionFrame.setLocation(suggestionFrame.getX(), this.getY() + this.getHeight());
        suggestionFrame.setVisible(true);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(updateSuggestions())
        updateDisplay();
        else
            suggestionFrame.setVisible(false);
        selectedEntry = 0;
        this.requestFocus();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int ID = e.getKeyCode();
        switch(ID){

            case 40:
                if(selectedEntry < displayValues.size() - 1) selectedEntry++;
                updateDisplay();
                break;

            case 38:
                if(selectedEntry > 0) selectedEntry--;
                updateDisplay();
                break;

            case 10:
                this.setText(displayValues.get(selectedEntry));
                break;

            case 27:
                suggestionFrame.setVisible(false);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
