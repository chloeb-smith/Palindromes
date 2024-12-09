/**
 * Chloe Smith
 * 11/8/2024
 * CSC-331-003
 * The purpose of this program is to read in words from a file, determine if
 * they are palindromes recursively, then write the palindromes to another file.
 */
import java.io.*;

public class PalindromeSmithChloe {
    public static void main(String[] args) throws IOException {
        // initializing a reader and writer
        BufferedReader reader = new BufferedReader(new FileReader("wordList.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("palindromes.txt"));
        String word;
        writer.write("Palindromes from wordList.txt \n---------------------------------\n");
        // loop to read in a word until the input file is empty
        while ((word = reader.readLine()) != null) {
            //call palindrome method
            String answer = palindrome(word);
            // if word is a palindrome it is written to palindrome file
            if (answer.equals("true")) {
                writer.write(word);
                writer.newLine();
            }
        }
        // closing reader and writer
        writer.close();
        reader.close();
    }

    /**
     * This method recursively determines if a word is a palindrome
     *
     * @param word (String): The word being tested
     * @return either recalls the method or returns true or false
     */
    public static String palindrome(String word) {
        // if String is empty or 1 letter it is technically a palindrome
        if (word.isEmpty() || word.length() == 1) {
            return "true";
            // if the two end letters match method is called with the parameter being
            // a substring of the word without the two letters already tested
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return palindrome(word.substring(1, word.length() - 1));
            // if two end letters don't match the word is not a palindrome and method returns false
        } else {
            return "false";
        }
    }
}

