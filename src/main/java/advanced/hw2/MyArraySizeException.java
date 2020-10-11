package advanced.hw2;

public class MyArraySizeException extends Exception {
    @Override
    public void printStackTrace() {
        System.out.println("Wrong size of array!");
    }
}
