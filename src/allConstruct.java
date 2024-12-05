import java.util.*;

public class allConstruct {
    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        // Create array of Lists to store all combinations for each position
        List<List<String>>[] table = new ArrayList[target.length() + 1];

        // Initialize all positions with empty lists
        for (int i = 0; i <= target.length(); i++) {
            table[i] = new ArrayList<>();
        }

        // Base case - empty string has one way to construct it (empty list)
        table[0].add(new ArrayList<>());

        // Build the table
        for (int i = 0; i <= target.length(); i++) {
            // Only proceed if current position has at least one way to construct
            if (!table[i].isEmpty()) {
                // Try each word in the wordBank
                for (String word : wordBank) {
                    // Check if word matches characters starting at position i
                    if (i + word.length() <= target.length() &&
                            target.substring(i, i + word.length()).equals(word)) {
                        // For each existing combination at current position
                        for (List<String> combination : table[i]) {
                            // Create new combination by copying current and adding new word
                            List<String> newCombination = new ArrayList<>(combination);
                            newCombination.add(word);
                            table[i + word.length()].add(newCombination);
                        }
                    }
                }
            }
        }

        // Return all of the ways to construct target
        return table[target.length()];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(allConstruct("purple",
                new String[]{"purp", "p", "ur", "le", "purpl"}));
        // [[purp, le], [p, ur, p, le]]

        System.out.println(allConstruct("abcdef",
                new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}));
        // [[ab, cd, ef], [abc, def]]

        System.out.println(allConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        // []

        System.out.println(allConstruct("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        // [[enter, a, p, ot, ent, p, ot], [enter, a, p, ot, en, t, p, ot], ...]
    }
}

// Time complexity: O(n^m) where:
//
//n is target length
//m is wordBank length
//(Exponential because we're storing all possible combinations)
//
//Space complexity: O(n^m) for storing all combinations