public class BinomialMemoRec {
    // Use long for moderate n; switch to BigInteger if values overflow.
    static long[][] memo;
    static boolean TRACE = false; // set true to print compute/cache messages

    /**
     * Public entry: compute C(n,k).
     * Uses symmetry k = min(k, n-k) so we only store half the table.
     */
    public static long binom(int n, int k) {
        if (k < 0 || k > n)
            return 0;
        // canonicalize k using symmetry so memo stores only half the row
        k = Math.min(k, n - k);
        return binomMemo(n, k);
    }

    /**
     * Top-down memoized recursive computation. Each call canonicalizes k again
     * to ensure safe indexing (defensive) and to allow binom(...) callers to
     * pass any k in 0..n.
     */
    private static long binomMemo(int n, int k) {
        // canonicalize k (defensive: ensures 0 <= k <= n/2)
        k = Math.min(k, n - k);

        // base case: after canonicalization only k == 0 is needed
        if (k == 0)
            return 1;

        // memo lookup
        if (memo[n][k] != -1) {
            if (TRACE)
                System.out.printf("cache hit C(%d,%d)=%d%n", n, k, memo[n][k]);
            return memo[n][k];
        }

        if (TRACE)
            System.out.printf("compute C(%d,%d)%n", n, k);

        long val = binomMemo(n - 1, k - 1) + binomMemo(n - 1, k);

        memo[n][k] = val; // store canonical value
        return val;
    }

    public static void main(String[] args) {
        int maxN = 20; // maximum n we will compute (change as needed)
        int queryK = 10; // example query k
        TRACE = false; // set true to see compute/cache messages

        // allocate memo table sized for canonical k values (0..floor(maxN/2))
        memo = new long[maxN + 1][(maxN / 2) + 1];
        for (int i = 0; i <= maxN; i++) {
            for (int j = 0; j < memo[i].length; j++)
                memo[i][j] = -1;
        }

        System.out.printf("C(%d,%d) = %d%n", maxN, queryK, binom(maxN, queryK));

        System.out.println("\nPascal's Triangle (first " + (maxN + 1) + " rows):");
        printPascalsTriangle(maxN + 1);
    }

    // Prints Pascal's Triangle up to numRows (numRows >= 1)
    public static void printPascalsTriangle(int numRows) {
        int maxRow = numRows - 1;
        int maxNumWidth = String.valueOf(binom(maxRow, maxRow / 2)).length();

        for (int n = 0; n < numRows; n++) {
            // Calculate leading spaces for center alignment
            int numSpaces = (numRows - n - 1) * (maxNumWidth + 1) / 2;
            for (int s = 0; s < numSpaces; s++)
                System.out.print(" ");

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
