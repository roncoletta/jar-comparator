package com.roncoletta.comparator;

import com.roncoletta.comparator.exception.ValidationException;
import com.roncoletta.comparator.file.FileReader;
import com.roncoletta.comparator.file.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by roncoletta on 01/10/16.
 */
public class Comparator {
    private String fileName1;
    private String fileName2;
    @Autowired
    private FileReader fileReader;
    @Autowired
    private FileValidator fileValidator;



    public Comparator() {
    }

    public boolean compareFiles(String fileName1, String fileName2) {
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        validateFilesNames();
        return isFileEquals();
    }

    private void validateFilesNames() {
        fileValidator.validateFileNameNotEmpty(fileName1);
        fileValidator.validateFileNameNotEmpty(fileName2);
    }

    private boolean isFileEquals() {
        if(compareNameFiles()){
            return true;
        }
        return compareFiles();
    }

    private boolean compareFiles()  {
        if(!fileValidator.isFileExist(fileName1) || !fileValidator.isFileExist(fileName2)){
            throw new ValidationException("Files not exists");
        }
        return true;
    }

    private boolean compareNameFiles() {
        return this.fileName1.equals(fileName2);
    }
}
