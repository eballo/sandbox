package com.bluecodex.java.module;

/**
 * Scrapper Class
 *
 * Responsable Class to scrap the text
 */
public class Scrapper {

    /**
     * Fetch the words for the given text
     * @param text where to get the words
     * @return an array of words
     */
    public String [] fetchWords(String text){
        return text.split(" ");
    }
}
