package com.bluecodex.java;

import com.bluecodex.java.module.Scrapper;
import com.bluecodex.java.service.loader.file.FileService;

import java.io.File;

/**
 * Main executable class
 */
public class WordScrapper {

    public static void main(String[] args) {

        Scrapper scrapper = new Scrapper();

        // FetchWords form a String
        String [] words = scrapper.fetchWords("Esto es una prueba para ver como funciona");

        for (String word:words) {
            System.out.println(word);
        }

        //Fetch words from a file
        String fileName = "files/Test1.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        String [] words2 =scrapper.fetchWordsFromFile(file.getPath());

        for (String word:words2) {
            System.out.println(word);
        }

    }



}
