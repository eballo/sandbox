package com.bluecodex.java;

import com.bluecodex.java.module.Scrapper;
import com.bluecodex.java.service.statistics.Statistics;

import java.io.File;

/**
 * Main executable class
 */
public class WordScrapper {

    public static void main(String[] args) {

        Scrapper scrapper = new Scrapper();
        Statistics statistics = null;

        // ------------------------------------------
        // FetchWords form a String
        // ------------------------------------------
        String [] words = scrapper.fetchWords("Esto es una prueba para ver como funciona la prueba la casa");

        //Statistics
        statistics = new Statistics(words);
        System.out.println(statistics);


        // ------------------------------------------
        //Fetch words from a file
        // ------------------------------------------
        String fileName = "files/Test1.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        String [] words2 =scrapper.fetchWordsFromFile(file.getPath());

        //Statistics
        statistics = new Statistics(words2);
        System.out.println(statistics);
    }



}
