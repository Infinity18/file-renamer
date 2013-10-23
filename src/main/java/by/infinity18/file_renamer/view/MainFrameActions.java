package by.infinity18.file_renamer.view;

import by.infinity18.file_renamer.FileObject;
import by.infinity18.file_renamer.controller.FileOperations;

import javax.swing.*;
import java.io.File;
import java.util.List;

import static by.infinity18.file_renamer.controller.FileOperations.listFiles;
import static by.infinity18.file_renamer.controller.FileOperations.replaceFileName;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

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
        this.parent.textToFindTextField.setEnabled(true);
        this.parent.replaceWithTextField.setEnabled(true);
    }

    public void changeOption() {
        FileTableModel fileTableModel = (FileTableModel) this.parent.filesTable.getModel();
        String textToFind = this.parent.textToFindTextField.getText();
        String replaceWith = this.parent.replaceWithTextField.getText();
        replaceFileName(fileTableModel.getFileObjects(), textToFind, replaceWith);
        fileTableModel.fireTableDataChanged();
    }

    public void renameFiles() {
        FileTableModel tableModel = (FileTableModel) this.parent.filesTable.getModel();
        List<FileObject> fileObjectList = tableModel.getFileObjects();
        if (fileObjectList.isEmpty()) {
            JOptionPane.showMessageDialog(this.parent, "File table is empty", "Error", ERROR_MESSAGE);
            return;
        }

        String textToFind = this.parent.textToFindTextField.getText();
        if (textToFind == null || textToFind.length() == 0) {
            JOptionPane.showMessageDialog(this.parent, "Text to find field is empty", "Error", ERROR_MESSAGE);
            return;
        }

        if (FileOperations.renameFileList(fileObjectList)) {
            JOptionPane.showMessageDialog(this.parent, "Files renamed successfully");
        } else {
            JOptionPane.showMessageDialog(this.parent, "Something went wrong", "Error", ERROR_MESSAGE);
        }
        openDir();
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
