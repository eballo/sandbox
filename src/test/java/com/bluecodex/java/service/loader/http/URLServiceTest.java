package com.bluecodex.java.service.loader.http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class URLServiceTest {

    private URLService urlService;
    private MockWebServer server;
    private HttpUrl baseUrl;

    @BeforeMethod
    public void setUp() throws Exception {

        urlService = new URLService();

        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        server = new MockWebServer();

        // Schedule some responses.
        server.enqueue(new MockResponse().setBody("<html><body> Hello world!</body></html>"));


        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        baseUrl = server.url("/test/content");

    }

    @AfterMethod
    public void afterTest() throws IOException {
        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }

    @Test
    public void load() throws IOException {

       String output =  urlService.load(baseUrl.toString());
       Assert.assertEquals(output, "Hello world!");

    }
}