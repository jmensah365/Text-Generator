import java.util.HashMap;
import edu.princeton.cs.algs4.StdRandom;

public class LetterInventory {
    private HashMap<Character, Integer> charMap = new HashMap<>();
    

    public void add(char letter) {
        if (charMap.containsKey(letter)) {
            int frequency = charMap.get(letter);
            charMap.put(letter, frequency + 1);
        } else {
            charMap.put(letter, 1);
        }
    }

    
    public char nextCharacter() {
        double total = 0;
        char letter = ' ';
        double threshold = StdRandom.uniform();
        for (int count: charMap.values()) {
           total += count;
        }
        for (char c : charMap.keySet()) {
            threshold = threshold - charMap.get(c)/total;
            if (threshold < 0) {
                return c;
        }

        }

        return letter;
    }

    // public static void main(String[] args) {
    //     LetterInventory x = new LetterInventory();
    //     x.add('a');
    //     x.add('b');
    //     x.add('a');
    //     x.add('c');
    //     x.add('a');
    //     char c = x.nextCharacter();
    //     System.out.println(c);
    // }

    
}
