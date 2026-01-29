public class recurr {
    public static void main(String[] args) {

        System.out.println(factorial(5));
        System.out.println(fibonnaci(7));
    }

    // factorial
    public static int factorial(int a) {
        if (a == 1)
            return 1;

        return a * factorial(a - 1);
    }

    public static int fibonnaci(int b) {
        System.out.println("b : " + b);
        if (b <= 1)
            return b;

        return fibonnaci(b - 2) + fibonnaci(b - 1);
    }
}
