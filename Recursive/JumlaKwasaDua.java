package Recursive;

public class JumlaKwasaDua {
    // formula : fn(m,n) = m^2 + (m+1)^2 + ... + n^2, where n>m;
    public static int squareSum(int m, int n) {
        int result = 0;
        for (; m <= n; m++) {
            // System.out.println("m is now : " + m);
            // System.out.println("result is now : " + result);
            result = result + (m * m);
        }
        return result;
    }

    public static int recursiveSquareSum(int m, int n) {
        if (m < n) {
            return (m * m) + recursiveSquareSum(m + 1, n);
        } else {
            return m * m;
        }
    }

    public static void main(String[] args) {
        System.out.println(squareSum(5, 10));
        System.out.println("Recursive :" + recursiveSquareSum(5, 10));
    }

}
