public class canSum {
    public static boolean canSum(int targetSum, int[] numbers) {
        // Create table with size targetSum + 1 initialized to false
        boolean[] table = new boolean[targetSum + 1];

        // Base case - 0 can always be reached by using no numbers
        table[0] = true;

        // Build the table
        for (int i = 0; i <= targetSum; i++) {
            // Only explore further if current position is reachable
            if (table[i]) {
                // Try each number in the array
                for (int num : numbers) {
                    // Only update if within bounds
                    if (i + num <= targetSum) {
                        table[i + num] = true;
                    }
                }
            }
        }

        // Return whether targetSum can be reached
        return table[targetSum];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(canSum(7, new int[]{2, 3}));        // true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));  // true
        System.out.println(canSum(7, new int[]{2, 4}));        // false
        System.out.println(canSum(8, new int[]{2, 3, 5}));     // true
        System.out.println(canSum(300, new int[]{7, 14}));     // false
    }
}