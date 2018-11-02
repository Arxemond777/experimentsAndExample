package a.a;

import java.util.Arrays;

public class QuickSort {
    private static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{5, 7, 8, 1, 3};
        sort(0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int low, int high) {
        int
                tmpLow = low,
                tmpHigh = high,
                pivot = arr[low+(high-low)/2];

        while (tmpLow<=tmpHigh) {
            while (arr[tmpLow]<pivot) tmpLow++;
            while (arr[tmpHigh]>pivot) tmpHigh--;

            if (tmpLow<=tmpHigh) {
                int tmp = arr[tmpLow];
                arr[tmpLow] = arr[tmpHigh];
                arr[tmpHigh] = tmp;

                tmpLow++;
                tmpHigh--;
            }
        }

        if (low<tmpHigh) sort(low, tmpHigh);
        if (tmpLow<high) sort(tmpLow, high);
    }
}
