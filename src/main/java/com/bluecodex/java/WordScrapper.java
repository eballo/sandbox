package com.bluecodex.java;

import com.bluecodex.java.module.Scrapper;
import com.bluecodex.java.service.statistics.Statistics;

import java.io.File;
import java.io.IOException;

/**
 * Main executable class
 */
public class WordScrapper {

    /**
     * Show Statistics from a String
     * @param text
     */
    public Statistics getStatisticsFromString(String text) {

        Scrapper scrapper = new Scrapper();
        Statistics statistics = null;

        String [] words = scrapper.fetchWords(text);

        //Statistics
        statistics = new Statistics(words);

        return statistics;

    }

    /**
     * Show Statistics from a File
     *
     * @param fileName
     * @throws IOException
     */
    public Statistics getStatisticsFromFile(String fileName) throws IOException{

        Scrapper scrapper = new Scrapper();
        Statistics statistics = null;

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        String [] words =scrapper.fetchWordsFromFile(file.getPath());

        //Statistics
        statistics = new Statistics(words);

        return statistics;
    }

    /**
     * Show Statistics from a URL
     *
     * @param url
     * @throws IOException
     */
    public Statistics getStatisticsFromURL(String url) throws IOException{

        Scrapper scrapper = new Scrapper();
        Statistics statistics = null;

        String [] words =scrapper.fetchWordsFromURL(url);

        //Statistics
        statistics = new Statistics(words);

        return statistics;
    }



}
