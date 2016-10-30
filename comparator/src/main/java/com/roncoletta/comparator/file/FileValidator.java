package com.roncoletta.comparator.file;

import com.roncoletta.comparator.exception.ValidationException;

import javax.inject.Named;
import java.nio.file.Paths;


/**
 * Created by roncoletta on 02/10/16.
 */
@Named
public class FileValidator {

    public enum RegexFilter{
        WAR_EAR_JAR_OR_ZIP_FILE(".[e,w,j]ar$|.zip$");

        private String regex;

        RegexFilter(String regex){
            this.regex = regex;
        }

        public String getRegex() {
            return regex;
        }
    }

    public void validateFileNameNotEmpty(String fileName) {
        validateFileNotNull(fileName);
        if (fileName.trim().isEmpty()){
            throw new ValidationException("File name cant be empty");
        }
        validateJarWarEarZip(fileName);
    }

    public boolean isFileExist(String fileName1) {
        return Paths.get(fileName1).toFile().exists();
    }


    private void validateJarWarEarZip(String fileName) {
        if(!RegexUtil.isMatch(RegexFilter.WAR_EAR_JAR_OR_ZIP_FILE.getRegex(), fileName)){
            throw new ValidationException("Extension not match");
        }
    }

    private void validateFileNotNull(String fileName1) {
        if (fileName1 == null ){
            throw new ValidationException("File name cant be null");
        }
    }




}
