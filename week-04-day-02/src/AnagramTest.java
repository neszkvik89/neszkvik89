import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
    Anagram myAnagram;

    @Before
    public void setup() {
        myAnagram = new Anagram();
    }

    @Test
    public void anagramFinderSameCharRepeated() {
        assertEquals(true, myAnagram.anagramFinder("aaaa", "aaaa"));
    }

    @Test
    public void anagramFinderFullMixChars() {
        assertEquals(true, myAnagram.anagramFinder("pazert", "raptez"));
    }
}