package by.infinity18.file_renamer.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static by.infinity18.file_renamer.view.Constants.*;
import static by.infinity18.file_renamer.view.SwingUtils.*;
import static java.awt.BorderLayout.*;
import static java.awt.Color.WHITE;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.event.KeyEvent.VK_ENTER;
import static javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;

/**
 * @author Evgeniy Myslovets
 * @date 11.10.13
 */
public class MainFrame extends JFrame {

    public JTextField dirTextField;
    public JTextField textToFindTextField;
    public JTextField replaceWithTextField;
    public JTable filesTable;

    private MainFrameActions actions = new MainFrameActions(this);

    public MainFrame() {
        setTitle(Constants.TITLE);
        setMinimumSize(new Dimension(800, 600));
        setJMenuBar(createMenu());
        getContentPane().add(createMainPanel());
        pack();
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        return menuBar;
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu(Constants.MENU_FILE);
        fileMenu.add(createExitMenuItem());
        return fileMenu;
    }

    private JMenuItem createExitMenuItem() {
        return createMenuItem(
                Constants.MENU_ITEM_EXIT,
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = createPanel(new BorderLayout());
        mainPanel.add(createTopPanel(), NORTH);
        mainPanel.add(createCenterPanel(), CENTER);
        return mainPanel;
    }

    private JPanel createTopPanel() {
        JPanel topPanel = createPanel(new GridBagLayout());
        this.dirTextField = createDirTextField();
        topPanel.add(this.dirTextField,
                new GridBagBucket()
                        .withGridX(0)
                        .withGridY(0)
                        .withWeightX(1)
                        .withFill(HORIZONTAL)
                        .toConstraints());
        topPanel.add(createChooseDirButton(),
                new GridBagBucket()
                        .withGridX(1)
                        .withGridY(0)
                        .toConstraints());
        topPanel.add(createOpenDirButton(),
                new GridBagBucket()
                        .withGridX(2)
                        .withGridY(0)
                        .toConstraints());
        topPanel.add(createExitDirButton(),
                new GridBagBucket()
                        .withGridX(3)
                        .withGridY(0)
                        .toConstraints());
        return topPanel;
    }

    private JButton createChooseDirButton() {
        return createButton(
                BUTTON_CHOOSE_DIR,
                new Dimension(100, 30),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        actions.chooseDir();
                    }
                },
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == VK_ENTER) {
                            actions.chooseDir();
                        }
                    }
                }
        );
    }

    private JButton createOpenDirButton() {
        return createButton(
                BUTTON_OPEN_DIR,
                new Dimension(100, 30),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        actions.openDir();
                    }
                },
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == VK_ENTER) {
                            actions.openDir();
                        }
                    }
                }
        );
    }

    private JButton createExitDirButton() {
        return createButton(
                BUTTON_EXIT_DIR,
                new Dimension(100, 30),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                },
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == VK_ENTER) {
                            System.exit(0);
                        }
                    }
                }
        );
    }

    private JTextField createDirTextField() {
        return createTextField(
                new Dimension(400, 30),
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == VK_ENTER) {
                            actions.openDir();
                        }
                    }
                }
        );
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = createPanel(new BorderLayout());
        centerPanel.add(createFileTable(), CENTER);
        centerPanel.add(createOptionPanel(), SOUTH);
        return centerPanel;
    }

    private JScrollPane createFileTable() {
        JScrollPane filesScrollPane = new JScrollPane();
        filesScrollPane.setViewportView(createFilesTable());
        return filesScrollPane;
    }

    private JTable createFilesTable() {
        this.filesTable = new JTable();
        this.filesTable.setBackground(WHITE);
        this.filesTable.setShowGrid(true);
        this.filesTable.setSelectionMode(MULTIPLE_INTERVAL_SELECTION);
        this.filesTable.setModel(new FileTableModel());
        return this.filesTable;
    }

    private JPanel createOptionPanel() {
        JPanel optionPanel = createPanel(new GridBagLayout());
        optionPanel.setBorder(new TitledBorder(OPTION));

        optionPanel.add(new JLabel(TEXT_TO_FIND),
                new GridBagBucket()
                        .withGridX(0)
                        .withGridY(0)
                        .toConstraints());
        this.textToFindTextField = createOptionTextField();
        optionPanel.add(this.textToFindTextField,
                new GridBagBucket()
                        .withGridX(1)
                        .withGridY(0)
                        .toConstraints());

        optionPanel.add(new JLabel(REPLACE_WITH),
                new GridBagBucket()
                        .withGridX(2)
                        .withGridY(0)
                        .toConstraints());
        this.replaceWithTextField = createOptionTextField();
        optionPanel.add(this.replaceWithTextField,
                new GridBagBucket()
                        .withGridX(3)
                        .withGridY(0)
                        .toConstraints());

        optionPanel.add(createRenameButton(),
                new GridBagBucket()
                        .withGridX(4)
                        .withGridY(0)
                        .toConstraints());

        return optionPanel;
    }

    private JTextField createOptionTextField() {
        return createTextField(
                new Dimension(100, 30),
                new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        actions.changeOption();
                    }
                },
                false);
    }

    private JButton createRenameButton() {
        return createButton(
                BUTTON_RENAME,
                new Dimension(100, 30),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        actions.renameFiles();
                    }
                },
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == VK_ENTER) {
                            actions.renameFiles();
                        }
                    }
                }
        );
    }

}