package com.roncoletta.comparator;

import com.roncoletta.comparator.file.FileReader;
import com.roncoletta.comparator.file.FileValidator;

import javax.inject.Inject;

/**
 * Created by roncoletta on 01/10/16.
 */
public class Comparator {
    private String fileName1;
    private String fileName2;
    @Inject
    private FileReader fileReader;
    @Inject
    private FileValidator fileValidator;



    public Comparator() {
    }

    private void validateFilesNames() {
        fileValidator.validateFileNameNotEmpty(fileName1);
        fileValidator.validateFileNameNotEmpty(fileName2);
    }


    public boolean compare(String fileName1, String fileName2) {
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        validateFilesNames();
        return isFileEquals();
    }

    private boolean isFileEquals() {
        if(compareNameFiles()){
            return true;
        }
        return compareFiles();
    }

    private boolean compareFiles() {
       // readFile(tytfileName1);
        return true;
    }

    private boolean compareNameFiles() {
        return this.fileName1.equals(fileName2);
    }
}
