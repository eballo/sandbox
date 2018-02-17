package com.bluecodex.java;

import com.bluecodex.java.module.Scrapper;
import com.bluecodex.java.service.statistics.Statistics;

import java.io.File;
import java.io.IOException;

/**
 * Main executable class
 */
public class WordScrapper {

    private Scrapper scrapper;

    public WordScrapper() {
        scrapper = new Scrapper();
    }

    /**
     * Show Statistics from a String
     * @param text
     */
    public Statistics getStatisticsFromString(String text) {


        Statistics statistics = null;
        String [] words = scrapper.fetchWords(text);

        //Statistics
        statistics = new Statistics(words);

        return statistics;

    }

    /**
     * Show Statistics from a File
     *
     * @param path
     * @throws IOException
     */
    public Statistics getStatisticsFromFile(String path) throws IOException{

        Statistics statistics = null;

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

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

        Statistics statistics = null;

        String [] words =scrapper.fetchWordsFromURL(url);

        //Statistics
        statistics = new Statistics(words);

        return statistics;
    }

    public Statistics getStatisticsFromEPub(String path) throws IOException{

        Statistics statistics = null;

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        String [] words =scrapper.fetchWordsFromEPub(file.getPath());

        //Statistics
        statistics = new Statistics(words);

        return statistics;
    }



}
