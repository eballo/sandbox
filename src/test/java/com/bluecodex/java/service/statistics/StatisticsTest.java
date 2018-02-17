package com.bluecodex.java.service.statistics;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StatisticsTest {

    private Statistics statistics;
    private String [] list ={"test","la","si","cosa","si"};

    @BeforeMethod
    public void setUp() throws Exception {

        statistics = new Statistics(list);

    }

    @Test
    public void testGetCounts() throws Exception {
        Map<String, Long> map = new HashMap<String,Long>();
        map.put("test",new Long(1));
        map.put("la",new Long(1));
        map.put("si",new Long(2));
        map.put("cosa",new Long(1));

        Map<String, Long> expectedTreeMap = new TreeMap<String, Long>(map);

        Assert.assertEquals(statistics.getWords(),expectedTreeMap);
    }

    @Test
    public void testGetTotal() throws Exception {

        Assert.assertEquals(statistics.getTotal(),5);

    }

    @Test
    public void testGetMaxValue(){

        Map.Entry<String, Long> entry =statistics.getMaxValue();
        Assert.assertEquals(entry.getKey(),"si");
        Assert.assertEquals(entry.getValue(),Long.valueOf(2));
    }

    @Test
    public void testUniqueValue(){
        Assert.assertEquals(statistics.getUniqueValues(),4);
    }

    @Test
    public void testToString(){

        String expected = "Statistics{total=5, uniqueValues=4, maxValue=si (2), words={cosa=1, la=1, si=2, test=1}}";

        Assert.assertEquals(statistics.toString(),expected);
    }
}