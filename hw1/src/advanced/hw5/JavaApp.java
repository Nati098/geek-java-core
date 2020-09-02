package advanced.hw5;

import java.util.Arrays;

public class JavaApp {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    private static Object o = new Object();

    public static void main(String[] args) {
        method1();

        try {
            method2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long t0 = System.currentTimeMillis();

        mapWithFormula(arr, Thread.currentThread().getName());

        System.out.println("Method1: " + (System.currentTimeMillis() - t0) + " ms");
        System.out.println("Res: ");
        printArr(Arrays.copyOfRange(arr, 0, 20));
    }

    public static void method2() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long t0 = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(() -> {
            mapWithFormula(arr1, Thread.currentThread().getName());
        });
        Thread t2 = new Thread(() -> {
            mapWithFormula(arr2, Thread.currentThread().getName());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Method2: " + (System.currentTimeMillis() - t0)  + " ms");
        System.out.println("Res arr1: ");
        printArr(Arrays.copyOfRange(arr1, 0, 20));
        System.out.println("Res arr2: ");
        printArr(Arrays.copyOfRange(arr2, 0, 20));
        System.out.println("Res arr (1st half): ");
        printArr(Arrays.copyOfRange(arr, 0, 20));
        System.out.println("Res arr (2nd half): ");
        printArr(Arrays.copyOfRange(arr, HALF, HALF+20));

    }

    public static float[] mapWithFormula(float[] arr, String threadName) {
        System.out.println(threadName+ " mapWithFormula");
        synchronized (o) {
            for (int i=0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
        
        return arr;
    }

    public static void printArr(float[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
