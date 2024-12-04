public class countConstruct {
    public static int countConstruct(String target, String[] wordBank) {
        // Create table with length target.length + 1 initialized to 0
        int[] table = new int[target.length() + 1];

        // Base case - empty string has 1 way to construct (using no words)
        table[0] = 1;

        // Build the table
        for (int i = 0; i <= target.length(); i++) {
            // Only proceed if current position has at least one way to construct
            if (table[i] > 0) {
                // Try each word in the wordBank
                for (String word : wordBank) {
                    // Check if word matches characters starting at position i
                    if (i + word.length() <= target.length() &&
                            target.substring(i, i + word.length()).equals(word)) {
                        // Add current number of ways to position after word
                        table[i + word.length()] += table[i];
                    }
                }
            }
        }

        // Return total number of ways to construct target
        return table[target.length()];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countConstruct("purple",
                new String[]{"purp", "p", "ur", "le", "purpl"}));     // 2
        System.out.println(countConstruct("abcdef",
                new String[]{"ab", "abc", "cd", "def", "abcd"}));     // 1
        System.out.println(countConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));  // 0
        System.out.println(countConstruct("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));     // 4
    }
}

// Time complexity: O(n * m * k) where:
//
//n is target length
//m is wordBank length
//k is average word length
//
//Space complexity: O(n) for the table array