package by.infinity18.file_renamer;

import by.infinity18.file_renamer.view.MainFrame;

import javax.swing.*;

/**
 * @author Evgeniy Myslovets
 * @date 11.10.13
 */
public class FileRenamer {

    private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

    public static void main(String[] args) {
        installLnF();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    mainFrame.setLocationRelativeTo(null);
                    mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void installLnF() {
        try {
            UIManager.setLookAndFeel(PREFERRED_LOOK_AND_FEEL);
        } catch (Exception e) {
            System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL + " on this platform: " + e.getMessage());
        }
    }
}
