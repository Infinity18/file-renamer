package by.infinity18.file_renamer.view;

import javax.swing.table.AbstractTableModel;
import java.io.File;

/**
 * @author Evgeniy Myslovets
 * @date 14.10.13
 */
public class FileTableModel extends AbstractTableModel {

    private File[] files;
    private static final String[] COLUMN_NAMES = {"Имя Файла"};

    public FileTableModel(File[] files) {
        this.files = files;
        fireTableDataChanged();
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    public int getRowCount() {
        return this.files != null ? this.files.length : 0;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        File file = this.files[rowIndex];
        return file.getName();
    }
}