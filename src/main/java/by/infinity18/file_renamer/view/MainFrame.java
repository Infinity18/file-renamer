package by.infinity18.file_renamer.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeniy Myslovets
 * @date 11.10.13
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle(Constants.TITLE);
        setMinimumSize(new Dimension(800, 600));

        addMenu();

        pack();
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu(Constants.MENU_FILE);
        fileMenu.add(createExitMenuItem());
        return fileMenu;
    }

    private JMenuItem createExitMenuItem() {
        JMenuItem exitMenuItem = new JMenuItem(Constants.MENU_ITEM_EXIT);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return exitMenuItem;
    }
}