package Hashing;

import java.util.function.Function;

public class hashing_probing {

    // h1(k) = 2k mod m;
    public static int h1_function(int k) {
        return (2 * k) % 9;
    }

    public static void main(String[] args) {
        // inputting array
        int[] A = { 45, 23, 102, 96, 116, 87 };

        // the hashing and probing algorithm
        int[] hashedA = hashing_plus_linearProbing(hashing_probing::h1_function, A, 9);

        // printing function
        printArr(hashedA);

        // searching values
        hashSearch(hashedA, 87);
        hashSearch(hashedA, 100);

    }

    public static int[] hashing_plus_linearProbing(Function<Integer, Integer> fn, int[] A, int m) {
        // final hashed array
        int[] hashedA = new int[m];

        for (int k : A) {

            // hashing function : h1(k) = 2k mod m;
            int hashedIndex = fn.apply(k);

            // linear probing
            hashedA = probeInsert(hashedA, hashedIndex, k);
        }

        return hashedA;

    }

    public static int[] probeInsert(int[] A, int index, int val) {
        int m = A.length;
        int probeIndex = index % m;
        if (A[probeIndex] != 0) {
            A = probeInsert(A, probeIndex + 1, val);
        } else {
            A[probeIndex] = val;
        }
        return A;
    }

    public static void hashSearch(int[] hashedA, int val) {

        // index from hash function
        int index = h1_function(val);

        // find the value starting from index
        int foundIndex = probeSearch(hashedA, index, val, 0);

        if (foundIndex != -1) {
            System.out.printf("Operation find %d : index %d\n", val, foundIndex);
        } else {
            System.err.printf("Operation find %d :  item not found\n", val);
        }

    }

    public static int probeSearch(int[] arr, int index, int val, int probe) {
        // not found after searching whole array
        if (probe >= arr.length)
            return -1;

        // make index go to front, after end of Array
        index = index % arr.length;

        if (arr[index] == val) {
            // found
            return index;
        } else {
            // search next room
            probe++;
            return probeSearch(arr, index + 1, val, probe);
        }
    }

    // Aesthetic table printing function
    public static void printArr(int[] A) {

        System.out.print("====".repeat(A.length));
        System.out.print("=\n|");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%3d|", i);
        }
        System.out.println();
        System.out.print("----".repeat(A.length));

        System.out.print("-\n|");
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                System.out.printf("%3s|", "");
            else
                System.out.printf("%3d|", A[i]);
        }
        System.out.print("\n=");
        System.out.println("====".repeat(A.length));
    }
}
