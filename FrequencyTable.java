
import java.util.HashMap;
import edu.princeton.cs.algs4.StdRandom;
public class FrequencyTable {
    private HashMap<String, LetterInventory> table = new HashMap<>();


    // a method to return a random key from a hash map
    public String randomKey() {
        Object[] keys = table.keySet().toArray();
        String randomKey = (String) keys[StdRandom.uniform(keys.length)];
        return randomKey;
    }

    // a method to increment the next character string for a string
    public void add(char letter, String k) {
        if (table.containsKey(k)) {
            LetterInventory characterInventory = table.get(k);
            characterInventory.add(letter);
        } else {
            table.put(k, new LetterInventory());
            LetterInventory characterInventory = table.get(k);
            characterInventory.add(letter);
        }
        
    }

    // a method to return the next random character for a given string
    public char selectCharacter(String k) {
        LetterInventory inv = table.get(k);
        return inv.nextCharacter();
    }
}
