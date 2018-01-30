package com.bluecodex.java.service.statistics;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.testng.Assert.*;

public class StatisticsTest {

    private Statistics statistics;
    private String [] list ={"test","la","si","cosa"};

    @BeforeMethod
    public void setUp() throws Exception {

        statistics = new Statistics(list);

    }

    @Test
    public void testGetCounts() throws Exception {
        Map<String, Long> map = new HashMap<String,Long>();
        map.put("test",new Long(1));
        map.put("la",new Long(1));
        map.put("si",new Long(1));
        map.put("cosa",new Long(1));

        Map<String, Long> expectedTreeMap = new TreeMap<String, Long>(map);

        Assert.assertEquals(statistics.getCounts(),expectedTreeMap);
    }

    @Test
    public void testGetTotal() throws Exception {

        Assert.assertEquals(statistics.getTotal(),4);

    }
}