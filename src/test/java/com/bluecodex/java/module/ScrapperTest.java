package com.bluecodex.java.module;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        //Assertion
        Assert.assertEquals(expected, result);


    }
}