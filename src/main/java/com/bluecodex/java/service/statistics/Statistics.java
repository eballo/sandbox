package com.bluecodex.java.service.statistics;

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
    private Map<String, Long> words;
    private Map.Entry<String, Long> maxValue;
    private int uniqueValues;

    public Statistics(String[] wordsList) {
        this(new ArrayList<>(Arrays.asList(wordsList)));
    }

    public Statistics(ArrayList<String> wordsList) {
        this.data = wordsList;
        total = data.size();
        //Create a Map of the given list, and then change it to TreeMap in order to have the values in order
        words = new TreeMap<String, Long>(data.stream().collect(Collectors.groupingBy(item -> item.toLowerCase(), Collectors.counting())));
        maxValue = getMaxValue();
        uniqueValues = words.size();
    }

    /**
     *
     * @return Return a Map with word and total of ocurrences of the word
     */
    public Map<String, Long> getWords() {
        return this.words;
    }

    /**
     *
     * @return Total number of words in the given list
     */
    public int getTotal() {
        return this.total;
    }

    /**
     * @return the unique value of words
     */
    public int getUniqueValues() {
        return this.uniqueValues;
    }

    /**
     * @return The max value
     */
    public Map.Entry<String, Long> getMaxValue(){

        Map.Entry<String, Long> maxEntry = null;

        for(Map.Entry<String, Long> entry : words.entrySet()){
            if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        }
        return maxEntry;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "total=" + total +
                ", uniqueValues=" + uniqueValues +
                ", maxValue=" + maxValue.getKey() + " ("+ maxValue.getValue() +")"+
                ", words=" + words +
                '}';
    }
}
