package by.infinity18.file_renamer.controller;

import by.infinity18.file_renamer.FileObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Evgeniy Myslovets
 * @date 11.10.13
 */
public class FileOperations {

    public static List<FileObject> listFiles(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.isDirectory()) {
            return Collections.emptyList();
        }
        File[] files = dir.listFiles();
        return buildFileObjectList(files);
    }

    public static void replaceFileName(List<FileObject> fileObjectList, String textToFind, String replaceWith) {
        for (FileObject fileObject : fileObjectList) {
            String oldName = fileObject.getOldName();
            String newName = oldName.replace(textToFind, replaceWith);
            fileObject.setNewName(newName);
        }
    }

    private static List<FileObject> buildFileObjectList(File[] files) {
        List<FileObject> fileObjectList = new ArrayList<FileObject>(files.length);
        for (File file : files) {
            fileObjectList.add(new FileObject(file));
        }
        return fileObjectList;
    }
}
