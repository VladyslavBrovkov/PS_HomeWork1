package homework.first.Task2Test;

import homework.first.Task2.HashtagUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class HashtagUtilTest {

    /**
     * Count Hashtags in List with normal conditions
     */
    @Test
    public void countHashtag() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello, where are #you from? I am from #England");
        stringList.add("What is your favourite #color? The best is #blue");
        stringList.add("#Blue color is amazing!");
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put("#blue", 2);
        expectedResult.put("#color", 1);
        expectedResult.put("#england", 1);
        expectedResult.put("#you", 1);
        Assert.assertEquals(expectedResult, HashtagUtil.countHashtag(stringList));
    }


    /**
     * Count Hashtags in List with duplicate Hashtags in one String with different Case
     */
    @Test
    public void countHashtagWithDuplicate() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello, i am from #England? Have you ever visited #England?");
        stringList.add("What is the most popular #language? The main #Language of my family is #English");
        Map<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put("#england", 1);
        expectedResult.put("#english", 1);
        expectedResult.put("#language", 1);
        assertEquals(expectedResult, HashtagUtil.countHashtag(stringList));
    }

    /**
     * Count Hashtags in Empty List
     */
    @Test
    public void countHashtagInEmptyList() {
        List<String> stringList = new ArrayList<>();
        int expectedListSize = 0;
        assertEquals(expectedListSize, HashtagUtil.countHashtag(stringList).size());
    }

    /**
     * Check NullPointerException message is thrown when Null value is present in input
     */
    @Test
    public void shouldThrowNullPointerException() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello, i am from #England? Have you ever visited #England?");
        stringList.add(null);
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> HashtagUtil.countHashtag(stringList));
        assertEquals("Null value is present", exception.getMessage());
    }
}
