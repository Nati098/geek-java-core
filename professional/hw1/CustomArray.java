package professional.hw1;

import professional.hw1.task3.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArray<T> {

    private T[] arr;

    public CustomArray(T[] arr) {
        this.arr = arr;
    }

    public T[] switchElements(int i, int j) {
        try {
            T buf = arr[i];
            arr[i] = arr[j];
            arr[j] = buf;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }
        return arr;
    }

    public ArrayList<T> toArrayList() {
        return (ArrayList<T>) Arrays.asList(arr);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("CustomArray: ");
        for (int i = 0; i < arr.length; i++) {
            res.append(i+")"+arr[i] + " -> ");
        }
//        for (T a : arr) {
//            res.append(a + " -> ");
//        }
        res.append("|");
        return res.toString();
    }
}
