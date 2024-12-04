import java.util.*;

public class bestSum {
    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        // Create array of ArrayLists to store combinations
        ArrayList<Integer>[] table = new ArrayList[targetSum + 1];

        // Initialize base case - empty list for sum 0
        table[0] = new ArrayList<>();

        // Build the table
        for (int i = 0; i <= targetSum; i++) {
            // Only proceed if current position has a valid combination
            if (table[i] != null) {
                // Try each number in the array
                for (int num : numbers) {
                    // Check if within bounds
                    if (i + num <= targetSum) {
                        // Create new combination
                        ArrayList<Integer> combination = new ArrayList<>(table[i]);
                        combination.add(num);

                        // Update if we found a shorter combination or if no combination exists yet
                        if (table[i + num] == null || combination.size() < table[i + num].size()) {
                            table[i + num] = combination;
                        }
                    }
                }
            }
        }

        // Return the shortest combination that sums to targetSum (or null if none exists)
        return table[targetSum];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));    // [7]
        System.out.println(bestSum(8, new int[]{2, 3, 5}));       // [3, 5]
        System.out.println(bestSum(8, new int[]{1, 4, 5}));       // [4, 4]
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25})); // [25, 25, 25, 25]
        System.out.println(bestSum(300, new int[]{7, 14}));       // null
    }
}


// Time complexity: O(n * m * m) where:
//
//n is targetSum
//m is length of numbers array
//Extra m factor from array copying
//
//Space complexity: O(n * m) for storing combinations