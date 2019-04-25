import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {
    CountLetters myCounter;
    HashMap<Character, Integer> testMap;

    @Before
    public void setup () {
        myCounter = new CountLetters();
        testMap = new HashMap<>();
    }


    @Test
    public void dictionaryTestWithAvgWord() {
        testMap.put('á', 1);
        testMap.put('a', 2);
        testMap.put('t', 1);
        testMap.put('u', 1);
        testMap.put('y', 1);
        testMap.put('j', 1);
        testMap.put('k', 3);
        testMap.put('l', 1);
        testMap.put('m', 2);
        testMap.put('o', 1);

        assertEquals(testMap, myCounter.dictionary("kutyámajmokkal"));
    }

    @Test
    public void dictionaryTestWithCases() {
        testMap.put('á', 1);
        testMap.put('a', 2);
        testMap.put('t', 1);
        testMap.put('u', 1);
        testMap.put('y', 1);
        testMap.put('j', 1);
        testMap.put('k', 3);
        testMap.put('l', 1);
        testMap.put('m', 2);
        testMap.put('o', 1);

        assertNotEquals(testMap, myCounter.dictionary("KutYáMAJmokKaL"));
    }

}