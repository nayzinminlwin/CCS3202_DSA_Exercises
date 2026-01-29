public class BinomialMemoRec {
    // Use long for moderate n; switch to BigInteger if values overflow.
    static long[][] memo;
    static boolean TRACE = false; // set true to print compute/cache messages

    static long binom(int n, int k) {

        if (k < 0 || k > n)
            return 0;
        k = Math.min(k, n - k); // symmetry optimization
        return binomMemo(n, k);
    }

    static long binomMemo(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        if (memo[n][k] != -1) {
            if (TRACE)
                System.out.printf("cache hit C(%d,%d)=%d%n", n, k, memo[n][k]);
            return memo[n][k];
        }

        if (TRACE)
            System.out.printf("compute C(%d,%d)%n", n, k);

        long val = binomMemo(n - 1, k - 1) + binomMemo(n - 1, k);

        memo[n][k] = val; // insert left side of symmetry
        memo[n][n - k] = val; // insert right side of symmetry

        return memo[n][k];
    }

    public static void main(String[] args) {
        int n = 20, k = 10;
        TRACE = false; // toggle to see recursion/computation vs cache hits

        memo = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                memo[i][j] = -1;

        System.out.printf("C(%d,%d) = %d%n", n, k, binom(n, k));
        // Print Pascal's Triangle for a small n
        System.out.println("\nPascal's Triangle (first 20 rows):");
        printPascalsTriangle(n);
    }

    // Prints Pascal's Triangle up to numRows
    public static void printPascalsTriangle(int numRows) {
        int maxNumWidth = String.valueOf(binom(numRows - 1, (numRows - 1) / 2)).length();
        for (int n = 0; n < numRows; n++) {
            // Calculate leading spaces for center alignment
            int numSpaces = (numRows - n - 1) * (maxNumWidth + 1) / 2;
            for (int s = 0; s < numSpaces; s++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= n; k++) {
                String num = String.valueOf(binom(n, k));
                // Pad each number to maxNumWidth
                while (num.length() < maxNumWidth)
                    num = " " + num;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
