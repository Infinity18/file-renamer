package by.infinity18.file_renamer.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

/**
 * @author Evgeniy Myslovets
 * @date 11.10.13
 */
public class SwingUtils {

    public static JMenuItem createMenuItem(String menuItemName, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(menuItemName);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    public static JPanel createPanel(LayoutManager layout) {
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        return panel;
    }

    public static JButton createButton(String buttonName, Dimension preferredSize, ActionListener actionListener, KeyAdapter keyListener) {
        JButton button = new JButton();
        button.setPreferredSize(preferredSize);
        button.setText(buttonName);
        button.addActionListener(actionListener);
        button.addKeyListener(keyListener);
        return button;
    }

    public static JTextField createTextField(Dimension preferredSize, KeyAdapter keyListener) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(preferredSize);
        textField.addKeyListener(keyListener);
        return textField;
    }

}
