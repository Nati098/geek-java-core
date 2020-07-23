package hw2;

import java.util.Arrays;
import java.util.Random;

public class JavaApp {

    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();

        getMinMax(generateArray(7, 100, 50));

        int[] arr = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("checkBalance: arr=" + Arrays.toString(arr) + " ---> " + checkBalance(arr));
        arr = new int[]{1, 1, 1, 2, 1};
        System.out.println("checkBalance: arr=" + Arrays.toString(arr) + " ---> " + checkBalance(arr));
        arr = new int[]{1, 1, 1, 2};
        System.out.println("checkBalance: arr=" + Arrays.toString(arr) + " ---> " + checkBalance(arr));
    }

    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("invertArray: " + Arrays.toString(arr) + " ---> ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 3 * i;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("changeArray: " + Arrays.toString(arr) + " ---> ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        int len = 5;
        int[][] arr = new int[len][len];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }

        System.out.println("fillDiagonal: ");
        print2dArray(arr);
    }

    public static void getMinMax(int[] arr) {
        System.out.print(Arrays.toString(arr) + " ---> ");

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            min = (arr[i] < min) ? arr[i] : min;
            max = Math.max(arr[i], max);
        }
        System.out.printf("min: %d, max: %d\n", min, max);
    }

    public static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }


    public static int[] generateArray(int len, int bound, int shift) {
        Random random = new Random();
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound) - shift;
        }
        return arr;
    }

    public static void print2dArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
