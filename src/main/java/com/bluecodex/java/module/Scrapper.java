package com.bluecodex.java.module;

import com.bluecodex.java.service.loader.file.FileService;

import java.io.IOException;

/**
 * Scrapper Class
 *
 * Responsable Class to scrap the text
 */
public class Scrapper {

    private FileService fileService;

    public Scrapper() {
        this.fileService = new FileService();
    }

    /**
     * Fetch the words for the given text, it is taking as a default separator one white space "\\s"
     *
     * The \\s is equivalent to [ \\t\\n\\x0B\\f\\r]
     * The \\s+ removes all whitespaces and non-visible characters (\\n, \\t, etc..). The + means one or more
     *
     * @param text the given text
     * @return an array of words
     */
    public String [] fetchWords(String text){
        return fetchWords(text, "\\s+");
    }

    /**
     * Fetch the words for the given text and separator
     * @param text the given text
     * @param regexSeparator the given separator
     * @return an array of words
     */
    public String [] fetchWords(String text, String regexSeparator){
        return text.split(regexSeparator);
    }

    /**
     * Fetch the words for the given file
     * @param path of the file
     * @return an array of words
     */
    public String [] fetchWordsFromFile(String path) throws IOException {
        return fetchWords(fileService.load(path));
    }
}
