package by.infinity18.file_renamer.view;

import by.infinity18.file_renamer.FileObject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeniy Myslovets
 * @date 14.10.13
 */
public class FileTableModel extends AbstractTableModel {

    private List<FileObject> fileObjects;
    private static final String[] COLUMN_NAMES = {"Old name", "New name"};

    public FileTableModel() {
        this.fileObjects = new ArrayList<FileObject>(0);
    }

    public FileTableModel(List<FileObject> fileObjects) {
        this.fileObjects = fileObjects;
        fireTableDataChanged();
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    public int getRowCount() {
        return this.fileObjects != null ? this.fileObjects.size() : 0;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return fileObjects.get(rowIndex).getOldName();
            case 1:
                return fileObjects.get(rowIndex).getNewName();
            default:
                return null;
        }
    }

    public List<FileObject> getFileObjects() {
        return fileObjects;
    }
}