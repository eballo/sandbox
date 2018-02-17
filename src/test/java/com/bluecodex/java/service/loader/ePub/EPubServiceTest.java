package com.bluecodex.java.service.loader.ePub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class EPubServiceTest {

    private EPubService ePubService;

    @BeforeMethod
    public void setUp() throws Exception {
        ePubService = new EPubService();
    }

    @Test
    public void testLoad() throws Exception {

        String bookName = "Metamorphosis-jackson.epub";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File bookFile = new File(classLoader.getResource(bookName).getFile());

        String output = ePubService.load(bookFile);

        System.out.println(output);
    }
}