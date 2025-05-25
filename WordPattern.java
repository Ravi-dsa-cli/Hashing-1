
import java.util.*;

//// char_toword: pattern char → word
//// word_tochar: word → char
//// If char_toword already has ch:
//// Check if it's mapped to the same word. If not, return false.
//// If word_tochar already has word:
//// Check if it's mapped to the same char. If not, return false.
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            }

            if (wordToChar.containsKey(word)) {
                if (!wordToChar.get(word).equals(ch)) {
                    return false;
                }
            }

            charToWord.put(ch, word);
            wordToChar.put(word, ch);
        }

        return true;
    }

    // Main method to test wordPattern
    public static void main(String[] args) {
        WordPattern sol = new WordPattern();

        System.out.println(sol.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(sol.wordPattern("abba", "dog dog dog dog")); // false
        System.out.println(sol.wordPattern("aaaa", "cat cat cat cat")); // true
        System.out.println(sol.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(sol.wordPattern("abc", "b c a"));             // true
    }
}
