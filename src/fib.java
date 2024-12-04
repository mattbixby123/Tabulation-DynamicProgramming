public class fib {
    public static long calculateFib(int n) {
        // Create table with n+1 size and initialize with 0s
        long[] table = new long[n + 1];

        // Set base case
        table[1] = 1;

        // Fill the table using the pattern shown
        for (int i = 0; i < n; i++) {
            // Add current value to next position if within bounds
            if (i + 1 < table.length) {
                table[i + 1] += table[i];
            }
            // Add current value to position after next if within bounds
            if (i + 2 < table.length) {
                table[i + 2] += table[i];
            }
        }

        // Return the nth number
        return table[n];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("fib(6) = " + calculateFib(6));   // 8
        System.out.println("fib(7) = " + calculateFib(7));   // 13
        System.out.println("fib(8) = " + calculateFib(8));   // 21
        System.out.println("fib(50) = " + calculateFib(50)); // 12586269025

        // Example of a larger number that still fits in long
        System.out.println("fib(92) = " + calculateFib(92)); // 7540113804746346429
    }
}