package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 88, 16, 8, 01, 33, 7 };

        arr = mergeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeSort(int[] arr) {

        if (arr.length <= 1)
            return arr;

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        int[] result = merge(mergeSort(left), mergeSort(right));

        return result;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] mergedArr = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mergedArr[k++] = left[i++];
            } else {
                mergedArr[k++] = right[j++];
            }
        }

        while (i < left.length)
            mergedArr[k++] = left[i++];

        while (j < right.length)
            mergedArr[k++] = right[j++];

        return mergedArr;

    }
}
