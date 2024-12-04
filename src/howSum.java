import java.util.*;

public class howSum {
    public static List<Integer> howSum(int targetSum, int[] numbers) {
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
                        // Create new combination by copying current and adding new number
                        table[i + num] = new ArrayList<>(table[i]);
                        table[i + num].add(num);
                    }
                }
            }
        }

        // Return the combination that sums to targetSum (or null if none exists)
        return table[targetSum];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(howSum(7, new int[]{2, 3}));        // [3, 2, 2]
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));  // [4, 3]
        System.out.println(howSum(7, new int[]{2, 4}));        // null
        System.out.println(howSum(8, new int[]{2, 3, 5}));     // [2, 2, 2, 2]
        System.out.println(howSum(300, new int[]{7, 14}));     // null
    }
}