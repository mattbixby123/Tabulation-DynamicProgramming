public class gridTraveler {
    public static long gridTraveler(int m, int n) {
        // Create 2D table with size (m+1) x (n+1) and initialize with 0s
        long[][] table = new long[m + 1][n + 1];

        // Base case - there is 1 way to travel a 1x1 grid
        table[1][1] = 1;

        // Fill the table using tabulation
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                long current = table[i][j];
                // Add current value to right neighbor if within bounds
                if (j + 1 <= n) {
                    table[i][j + 1] += current;
                }
                // Add current value to bottom neighbor if within bounds
                if (i + 1 <= m) {
                    table[i + 1][j] += current;
                }
            }
        }

        // Return value at target position
        return table[m][n];
    }

    public static void main(String[] args) {
        // Test cases matching the JavaScript example
        System.out.println(gridTraveler(1, 1));  // 1
        System.out.println(gridTraveler(2, 3));  // 3
        System.out.println(gridTraveler(3, 2));  // 3
        System.out.println(gridTraveler(3, 3));  // 6
        System.out.println(gridTraveler(18, 18)); // 2333606220
    }
}