package Recursive;

public class RecurisvesFunctions {
    public static int RecursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * RecursiveFactorial(n - 1);
        }
    }

    public static int Fibonacci(int n) {
        System.out.print("Olaa" + n);
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public static int exe2(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * exe2(x, n - 1);
        }
    }

    public static int minimalMove_4_towerOfHanoi(int n) {
        if (n == 0)
            return 1;
        else
            return (int) Math.pow(2, n) - 1;
    }

    public static int sumOfFirst_n_naturalNumbers(int n) {
        if (n == 1)
            return 1;
        else
            return n + sumOfFirst_n_naturalNumbers(n - 1);
    }

    public static void main(String[] args) {
        // System.out.println(RecursiveFactorial(4));
        // System.out.println(Fibonacci(50));
        // System.out.println(exe2(2, 10));
        System.out.println(minimalMove_4_towerOfHanoi(3));
        System.out.println(sumOfFirst_n_naturalNumbers(5));
    }
}
