package by.infinity18.file_renamer;

import java.io.File;

/**
 * @author Evgeniy Myslovets
 * @date 21.10.13
 */
public class FileObject {

    private File file;
    private String oldName;
    private String newName;

    public FileObject(File file) {
        this.file = file;
        this.oldName = file.getName();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
