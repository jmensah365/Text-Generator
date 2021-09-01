import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.algs4.In;

public class GeneratorTests {
    TextGenerator makeGenerator(int k, String filename) {
        return new TextGenerator(k, filename);
    }

    @Test
    void level1() {
        TextGenerator gen = makeGenerator(1, "small.txt");
        In file = new In("small.txt");
        String input = file.readAll();
        String text = gen.generate(500);
        assertEquals(500, text.length(), "generate returned a string of the wrong length");
        for (int i = 0; i < text.length() - 1; i++) {
            String substring = text.substring(i, i + 2);
            assertTrue(input.contains(substring), "the sequence " + substring
                    + " appears in string returned by generate, but never appears in original input");
        }
    }

    @Test
    void level2() {
        int k = 2;
        TextGenerator gen = makeGenerator(k, "The Odyssey.txt");
        In file = new In("The Odyssey.txt");
        String input = file.readAll();
        String text = gen.generate(500);
        assertEquals(500, text.length(), "generate returned a string of the wrong length");
        for (int i = 0; i < text.length() - k; i++) {
            String substring = text.substring(i, i + k + 1);
            assertTrue(input.contains(substring), "the sequence " + substring
                    + " appears in string returned by generate, but never appears in original input");
        }
    }

    @Test
    void level4() {
        int k = 4;
        TextGenerator gen = makeGenerator(k, "The Odyssey.txt");
        In file = new In("The Odyssey.txt");
        String input = file.readAll();
        String text = gen.generate(500);
        assertEquals(500, text.length(), "generate returned a string of the wrong length");
        for (int i = 0; i < text.length() - k; i++) {
            String substring = text.substring(i, i + k + 1);
            assertTrue(input.contains(substring), "the sequence " + substring
                    + " appears in string returned by generate, but never appears in original input");
        }
    }

    @Test
    void level8() {
        int k = 8;
        TextGenerator gen = makeGenerator(k, "The Odyssey.txt");
        In file = new In("The Odyssey.txt");
        String input = file.readAll();
        String text = gen.generate(500);
        assertEquals(500, text.length(), "generate returned a string of the wrong length");
        for (int i = 0; i < text.length() - k; i++) {
            String substring = text.substring(i, i + k + 1);
            assertTrue(input.contains(substring), "the sequence " + substring
                    + " appears in string returned by generate, but never appears in original input");
        }
    }

    @Test
    void isRandom() {
        TextGenerator gen = makeGenerator(1, "small.txt");
        assertNotEquals(gen.generate(100), gen.generate(100));
    }

    double countOccurances(String s, String sub) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = s.indexOf(sub, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += sub.length();
            }
        }

        return count;
    }

    @Test
    void usesFrequency() {
        // { ={t=3, i=1}, a={t=1}, r={ =2}, s={ =1}, t={e=1, h=4}, e={ =1, a=1, r=1,
        // i=1}, h={e=3, i=1}, i={r=1, s=1, n=1}, n={g=1}}
        TextGenerator gen = makeGenerator(1, "small.txt");
        String text = gen.generate(100000);
        assertEquals(3.0, countOccurances(text, " t") / countOccurances(text, " i"), 0.2);
        assertEquals(4.0, countOccurances(text, "th") / countOccurances(text, "te"), 0.2);
        assertEquals(1.0, countOccurances(text, "e ") / countOccurances(text, "ea"), 0.2);
        assertEquals(1.0, countOccurances(text, "er") / countOccurances(text, "ea"), 0.2);
        assertEquals(1.0, countOccurances(text, "er") / countOccurances(text, "ei"), 0.2);
        assertEquals(3.0, countOccurances(text, "he") / countOccurances(text, "hi"), 0.2);
        assertEquals(1.0, countOccurances(text, "ir") / countOccurances(text, "is"), 0.2);
        assertEquals(1.0, countOccurances(text, "is") / countOccurances(text, "in"), 0.2);
    }
}
