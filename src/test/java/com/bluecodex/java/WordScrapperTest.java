package com.bluecodex.java;

import com.bluecodex.java.service.statistics.Statistics;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class WordScrapperTest {

    private WordScrapper wordScrapper;

    @BeforeMethod
    public void setUp() throws Exception {
        wordScrapper = new WordScrapper();
    }

    @Test
    public void getStatisticsFromStringTest(){

        Statistics result = wordScrapper.getStatisticsFromString("en un lugar de la mancha");

        Assert.assertEquals(result.getTotal(), 6);

    }

    @Test
    public void getStatisticsFromFileTest() throws IOException{

        String fileName = "Test1.txt";
        Statistics result = wordScrapper.getStatisticsFromFile(fileName);

        Assert.assertEquals(result.getTotal(), 1565);
    }
}