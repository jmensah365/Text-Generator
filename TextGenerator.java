/**
 * Name: Jeremiah Mensah
 * Email: mensahj@carleton.edu
 * Description: Generating text
 */

import edu.princeton.cs.algs4.In;

public class TextGenerator {
    // private freqtable
    private FrequencyTable freq = new FrequencyTable();
    /**
     * Construct a new text generator by performing level k analysis on the text in filename
     * @param k The level of analysis
     * @param filename The name of the input file
     */
    public TextGenerator(int k, String filename) {
        // suggestion: process the input file and build up your table of frequencies
        //             here in the constructor

        // open the file
        In file = new In(filename);
        // perhaps use a String variable to keep track of the most recent k characters
        String current = "";
        int counter = 0;
        while (file.hasNextChar()) {
            // process the file character-by-character
            char nextChar = file.readChar();
            if (counter < k) {
                current += nextChar;
                counter++;
            } else {
                freq.add(nextChar, current);
                current = current.substring(1);
                current = current + nextChar;
            }
        }
    }

    /**
     * Generate and return a random string based on the input text
     * @param length The number of characters worth of random text to generate
     * @return A string of length characters produced by level k frequency analysis
     */
    public String generate(int length) {
        String output = freq.randomKey();
        String current = output;
        while (output.length() < length) {
            char nextChar = freq.selectCharacter(current);
            output = output + nextChar;
            current = current.substring(1);
            current = current + nextChar; 
        }
        return output;
    }

    public static void main(String[] args) {
        TextGenerator gen = new TextGenerator(8, "The Odyssey.txt");
        System.out.println(gen.generate(1000));
    }
}


