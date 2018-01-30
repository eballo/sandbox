package com.bluecodex.java.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Statistics class
 *
 * This Class Will genereate all kind of numbers for the given lists of words.
 *
 */
public class Statistics {

    private ArrayList<String> data;
    private int total;
    private Map<String, Long> counts;

    public Statistics(String[] wordsList) {
        this(new ArrayList<>(Arrays.asList(wordsList)));
    }

    public Statistics(ArrayList<String> wordsList) {
        this.data = wordsList;
        total = data.size();
        //Create a Map of the given list, and then change it to TreeMap in order to have the values in order
        counts = new TreeMap<String, Long>(data.stream().collect(Collectors.groupingBy(item -> item.toLowerCase(), Collectors.counting())));
    }

    /**
     *
     * @return Return a Map with word and total of ocurrences of the word
     */
    public Map<String, Long> getCounts() {
        return this.counts;
    }

    /**
     *
     * @return Total number of words in the given list
     */
    public int getTotal() {
        return this.total;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                ", total=" + total +
                ", counts=" + counts +
                '}';
    }
}
