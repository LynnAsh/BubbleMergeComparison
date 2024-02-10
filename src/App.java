import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static int[] createArr(int length) {
        int arr[] = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(101);
        }

        return arr;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length-i-1; k++) {
                if (arr[k] > arr[k+1]) {
                    int temp = arr[k+1];
                    arr[k+1] = arr[k];
                    arr[k] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (right-left > 1) {
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid,right);
            merge(arr,left,mid,right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, right);
        int i = 0, j = 0;
        for (int k = left; k < right; k++) {
            if (i == leftArr.length) {
                arr[k] = rightArr[j++];
            } else if (j == rightArr.length) {
                arr[k] = leftArr[i++];
            } else if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i++];
            } else {
                arr[k] = rightArr[j++];
            }
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter array length: ");
        Scanner scnr = new Scanner(System.in);
        String usrIn = scnr.nextLine();

        int arrLength = Integer.parseInt(usrIn);
        int arr[] = new int[arrLength];
        arr = createArr(arrLength);

        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("Bubble sort total time: " + totalTime + " ms");

        arr = createArr(arrLength);

        start = System.currentTimeMillis();
        mergeSort(arr);
        end = System.currentTimeMillis();
        totalTime = end - start;
        System.out.println("Merge sort total time: " + totalTime + " ms");

        scnr.close();
    }
}
