public class canConstruct {
    public static boolean canConstruct(String target, String[] wordBank) {
        // Create table with length target.length + 1 initialized to false
        boolean[] table = new boolean[target.length() + 1];

        // Base case - empty string can always be constructed
        table[0] = true;

        // Build the table
        for (int i = 0; i <= target.length(); i++) {
            // Only proceed if current position is constructible
            if (table[i]) {
                // Try each word in the wordBank
                for (String word : wordBank) {
                    // Check if word matches characters starting at position i
                    if (i + word.length() <= target.length() &&
                            target.substring(i, i + word.length()).equals(word)) {
                        // Mark the position after the word as constructible
                        table[i + word.length()] = true;
                    }
                }
            }
        }

        // Return whether the entire target string can be constructed
        return table[target.length()];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(canConstruct("abcdef",
                new String[]{"ab", "abc", "cd", "def", "abcd"}));     // true
        System.out.println(canConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));  // false
        System.out.println(canConstruct("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));     // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee"}));    // false
    }
}

// Time complexity: O(n * m * m) where:
//
//n is targetSum
//m is length of numbers array
//Extra m factor from array copying
//
//Space complexity: O(n * m) for storing combinations
