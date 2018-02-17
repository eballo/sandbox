package com.bluecodex.java;

import com.bluecodex.java.service.loader.http.URLService;
import com.bluecodex.java.service.statistics.Statistics;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class WordScrapperTest {

    private WordScrapper wordScrapper;
    private MockWebServer server;
    private HttpUrl baseUrl;

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

    @Test
    public void getStatisticsFromURL() throws IOException{

        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        server = new MockWebServer();

        // Schedule some responses.
        server.enqueue(new MockResponse().setBody("Hello world"));


        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        baseUrl = server.url("/test/content");

        Statistics result = wordScrapper.getStatisticsFromURL(baseUrl.toString());

        Assert.assertEquals(result.getTotal(), 2);

        server.shutdown();
    }
}