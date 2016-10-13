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

import java.io.FileNotFoundException;

/**
 * Created by roncoletta on 01/10/16.
 */
@RunWith(value = MockitoJUnitRunner.class)
public class ComparatorTest {

    @InjectMocks
    Comparator comparator;
    FileReader fileReader =  Mockito.mock(FileReader.class);
    FileValidator fileValidator = Mockito.mock(FileValidator.class);

    @org.junit.Before
    public void setUp() throws Exception {
        Mockito.doThrow(ValidationException.class).when(fileValidator).validateFileNameNotEmpty(null);
        Mockito.doThrow(ValidationException.class).when(fileValidator).validateFileNameNotEmpty("");
        Mockito.doThrow(ValidationException.class).when(fileValidator).validateFileNameNotEmpty(" ");
    }

    @Test
    public void create_new_comparator_with_two_files(){
        String fileName1 = "wqeqwee";
        String fileName2 = "3423423";
        comparator.compare(fileName1, fileName2);
    }

    @Test(expected = ValidationException.class)
    public void if_both_params_are_null_expected_exception(){
        comparator.compare(null, null);
    }

    @Test(expected = ValidationException.class)
    public void if_namefileOne_is_not_null_but_nameFale2_is_null_expected_exception(){

        comparator.compare("", null);
    }

    @Test(expected = ValidationException.class)
    public void if_namefileOne_is_null_and_nameFale2_is_not_null_expected_exception(){
        comparator.compare(null, "");
    }

    @Test(expected = ValidationException.class)
    public void if_params_dont_have_information_expected_exception(){
        String fileName1 = "";
        String fileName2 = "";
        comparator.compare(fileName1, fileName2);
    }

    @Test
    public void if_compare_two_equals_nameFiles_comparator_must_return_true(){
        String fileName1 = "fileName1";
        String fileName2 = "fileName1";

        Assert.assertTrue(comparator.compare(fileName1, fileName2));
    }

    @Test(expected = FileNotFoundException.class)
    public void if_two_filesNames_are_different_but_file_one_not_existe_throw_exception(){
        String fileName1 = "file1";
        String fileName2 = "file2";
        comparator.compare(fileName1, fileName2);
    }

}