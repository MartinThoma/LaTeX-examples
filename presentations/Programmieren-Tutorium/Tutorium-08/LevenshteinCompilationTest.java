import levenshtein.Levenshtein;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.assertEquals;

public class LevenshteinCompilationTest {

    public LevenshteinCompilationTest() {
    }

    @Test(timeout = 10000)
    public void runTest() {
        Levenshtein levenshtein = new Levenshtein("nämlich", "dämlich");
        assertEquals("Incorrect result comparing nämlich and dämlich", 1, levenshtein.getDistance());
    }

    public static void main(String[] args) throws Exception {                    
        JUnitCore.main(LevenshteinCompilationTest.class.getName());            
    }
}
