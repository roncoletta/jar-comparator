package com.roncoletta.comparator;

import com.roncoletta.comparator.exception.ValidationException;
import com.roncoletta.comparator.file.FileReader;
import com.roncoletta.comparator.file.FileValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by roncoletta on 01/10/16.
 */
@RunWith(value = MockitoJUnitRunner.class)
public class ComparatorTest {

    @InjectMocks
    Comparator comparator;
    FileReader fileReader =  Mockito.mock(FileReader.class);
    FileValidator fileValidator = Mockito.mock(FileValidator.class);
    private String fileName1 = "fileName1.jar";
    private String fileName2 = "fileName2.jar";

    @org.junit.Before
    public void setUp() throws Exception {
        Mockito.doThrow(ValidationException.class).when(fileValidator).validateFileNameNotEmpty(null);
        Mockito.doThrow(ValidationException.class).when(fileValidator).validateFileNameNotEmpty("");

    }

    @Test(expected = ValidationException.class)
    public void if_both_params_are_null_expected_exception(){
        comparator.compareFiles(null, null);
    }

    @Test(expected = ValidationException.class)
    public void if_namefileOne_is_not_null_but_nameFale2_is_null_expected_exception(){

        comparator.compareFiles("", null);
    }

    @Test(expected = ValidationException.class)
    public void if_namefileOne_is_null_and_nameFale2_is_not_null_expected_exception(){
        comparator.compareFiles(null, "");
    }

    @Test(expected = ValidationException.class)
    public void if_params_dont_have_information_expected_exception(){
        comparator.compareFiles("", "");
    }

    @Test
    public void if_compare_two_equals_nameFiles_comparator_must_return_true(){
        Assert.assertTrue(comparator.compareFiles(fileName1, fileName1));
    }

    @Test(expected = ValidationException.class)
    public void if_two_filesNames_are_different_but_file_one_not_existe_throw_exception(){
        comparator.compareFiles(fileName1, fileName2);
    }

    @Test(expected = ValidationException.class)
    public void file1_doesNot_exists_then_throw(){
        String fileName1 = "wqeqwee.zip";
        String fileName2 = "3423423.zip";
        Mockito.doReturn(false).when(fileValidator).isFileExist("wqeqwee.zip");
        comparator.compareFiles(fileName1, fileName2);
    }

    @Test(expected = ValidationException.class)
    public void file1_exists_but_file2_doesNot_then_throw(){
        String fileName1 = "wqeqwee.zip";
        String fileName2 = "3423423.zip";
        Mockito.doReturn(true).when(fileValidator).isFileExist("wqeqwee.zip");
        Mockito.doReturn(false).when(fileValidator).isFileExist("3423423.zip");

        comparator.compareFiles(fileName1, fileName2);
    }

    @Test
    public void file1_and_file2_are_equals_then_return_true(){
        String fileName1 = "wqeqwee.zip";
        String fileName2 = "3423423.zip";
        Mockito.doReturn(true).when(fileValidator).isFileExist("wqeqwee.zip");
        Mockito.doReturn(true).when(fileValidator).isFileExist("3423423.zip");

        Assert.assertTrue(comparator.compareFiles(fileName1, fileName2));
    }

}