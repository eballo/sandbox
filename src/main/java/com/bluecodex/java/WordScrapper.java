package com.bluecodex.java;

import com.bluecodex.java.module.Scrapper;

/**
 * Main executable class
 */
public class WordScrapper {

    public static void main(String[] args) {

        Scrapper scrapper = new Scrapper();

        String [] words = scrapper.fetchWords("Esto es una prueba para ver como funciona");

        for (String word:words) {
            System.out.println(word);
        }

    }



}
