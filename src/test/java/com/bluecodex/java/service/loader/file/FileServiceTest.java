package com.bluecodex.java.service.loader.file;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.*;

public class FileServiceTest {

    private FileService fileService;
    private String expectedContent;

    @BeforeMethod
    public void setUp() throws Exception {
        fileService = new FileService();
    }

    @Test
    public void testLoad() throws Exception {

        expectedContent ="This is the content of the file.\n" +
                "\n" +
                "This is a simple test.";

        String fileName = "expectedContent-test1.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + file.exists() + " : " + file.getPath());


        String content = fileService.load(file.getPath());

        System.out.println("The content is: "+content);

        Assert.assertEquals(expectedContent, content);
    }

    @Test
    public void testLoadEncodeCharset() throws Exception {

        expectedContent ="This is the content of the file.\n" +
                "\n" +
                "This is a simple test.";

        String fileName = "expectedContent-test1.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + file.exists() + " : " + file.getPath());


        String content = fileService.load(file.getPath(), StandardCharsets.UTF_8);

        System.out.println("The content is: "+content);

        Assert.assertEquals(expectedContent, content);
    }

}