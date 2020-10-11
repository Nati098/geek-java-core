package advanced.hw2;

public class MyArrayDataException extends Exception {
    private int row;
    private int column;


    public MyArrayDataException(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public void printStackTrace() {
        System.out.println(String.format("Cannot cast string to int in row: %d, column: %d", row, column));
    }
}
