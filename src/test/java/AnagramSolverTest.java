import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AnagramSolverTest {

    private String filename;
    private HashMap<String, ArrayList<String>> hm;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        filename = "src/main/resources/words_alpha.txt";
        hm = AnagramSolver.anagrams(filename);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        filename = null;
        hm = null;
    }

    @org.junit.jupiter.api.Test
    void mostFrequentAnagram() {
        String[] words = {"alerts", "alters", "artels", "estral", "laster", "lastre", "rastle", "ratels", "relast", "resalt", "salter", "slater", "staler", "stelar", "talers"};
        ArrayList<String> topWords = AnagramSolver.mostFrequentAnagram(hm);
        assert topWords != null;
        assertEquals(words.length, topWords.size());
        for (String word: words) {
            assertTrue(topWords.contains(word));
        }
    }

}