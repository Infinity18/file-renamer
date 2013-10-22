package by.infinity18.file_renamer.view;

import javax.swing.*;
import java.io.File;

import static by.infinity18.file_renamer.controller.FileOperations.listFiles;
import static by.infinity18.file_renamer.controller.FileOperations.replaceFileName;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;

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
        String dirName = getDirectoryName();
        this.parent.dirTextField.setText(dirName);
    }

    public void openDir() {
        String dirPath = this.parent.dirTextField.getText();
        System.out.println("Open dir: " + dirPath);
        this.parent.filesTable.setModel(new FileTableModel(listFiles(dirPath)));
    }

    public void changeOption() {
        FileTableModel fileTableModel = (FileTableModel) this.parent.filesTable.getModel();
        String textToFind = this.parent.textToFindTextField.getText();
        String replaceWith = this.parent.replaceWithTextField.getText();
        replaceFileName(fileTableModel.getFileObjects(), textToFind, replaceWith);
        fileTableModel.fireTableDataChanged();
    }

    private String getDirectoryName() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(this.parent) == APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }
}
