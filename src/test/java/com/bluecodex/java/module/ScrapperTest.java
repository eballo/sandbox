package com.bluecodex.java.module;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class ScrapperTest {

    private Scrapper scrapper;

    @BeforeMethod
    public void setUp() throws Exception {

        scrapper = new Scrapper();
    }

    @Test
    public void testFetchWords() throws Exception {

        //Expectation
        String text = "hoy es miercoles";
        String [] expected = {"hoy","es","miercoles"};

        String [] result = scrapper.fetchWords(text);

        //Print output
        printArray(expected, result);

        //Assertion
        Assert.assertEquals(result.length, expected.length);

    }

    @Test
    public void testFetchWordsWithMoreThanOneWhiteSpace() throws Exception {

        //Expectation
        String text = "hoy es  miercoles    y me da   igual";
        String [] expected = {"hoy","es","miercoles","y","me","da","igual"};

        String [] result = scrapper.fetchWords(text);

        //Print output
        printArray(expected, result);

        //Assertion
        Assert.assertEquals(result.length, expected.length);

    }

    /**
     * Helper method to print arrays
     * @param expected expected array
     * @param actual actual array
     */
    private void printArray(String [] expected, String [] actual){
        System.out.println(Arrays.deepToString(expected));
        System.out.println(Arrays.deepToString(actual));
    }
}
