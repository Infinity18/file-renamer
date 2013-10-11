package by.infinity18.file_renamer.view;

import javax.swing.*;

/**
 * @author Evgeniy Myslovets
 * @date 11.10.13
 */
public class MainFrameActions {

    private MainFrame parent;

    public MainFrameActions(MainFrame parent) {
        this.parent = parent;
    }

    public void chooseDir() {
        JOptionPane.showMessageDialog(this.parent, "Choose Dir");
    }

    public void openDir() {
        JOptionPane.showMessageDialog(this.parent, "Open Dir");
    }
}
