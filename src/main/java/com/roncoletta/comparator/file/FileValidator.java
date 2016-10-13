package com.roncoletta.comparator.file;

import com.roncoletta.comparator.exception.ValidationException;

/**
 * Created by roncoletta on 02/10/16.
 */
public class FileValidator {
    private final String REGEX_WAR_EAR_JAR_OR_ZIP_FILE = ".[e,w,j]ar$|.zip$";


    public void validateFileNameNotEmpty(String fileName) {
        validateFileNotNull(fileName);
        if (fileName.trim().isEmpty()){
            throw new ValidationException("File name cant be empty");
        }
        validateJarWarEarZip(fileName);
    }

    private void validateJarWarEarZip(String fileName) {

    }

    private void validateFileNotNull(String fileName1) {
        if (fileName1 == null ){
            throw new ValidationException("File name cant be null");
        }
    }


}
