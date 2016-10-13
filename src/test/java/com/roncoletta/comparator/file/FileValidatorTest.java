package com.roncoletta.comparator.file;

import com.roncoletta.comparator.exception.ValidationException;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 * Created by roncoletta on 02/10/16.
 */
@RunWith(value = JUnit4ClassRunner.class)
public class FileValidatorTest {

    FileValidator fileValidator = new FileValidator();

    @Test(expected = ValidationException.class)
    public void if_fileName_isNull_throwException(){
        fileValidator.validateFileNameNotEmpty(null);
    }

    @Test(expected = ValidationException.class)
    public void if_fileName_isEmpty_throwException(){
        fileValidator.validateFileNameNotEmpty("");
    }

    @Test(expected = ValidationException.class)
    public void if_fileName_isBlank_throwException(){
        fileValidator.validateFileNameNotEmpty(" ");
    }


}