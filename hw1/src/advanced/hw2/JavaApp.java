package advanced.hw2;

public class JavaApp {

    public static void main(String[] args) {
        String[][] arr1 = {
                {"12","14","53","a"},
                {"1.2","14","sa","22"},
                {"12","14"},
                {"12","14","453579","23"}
        };

        String[][] arr2 = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","1","2","3"},
                {"4","5","6","7"}
        };

        try {
            isArrayValid(arr1);
            castAndSum(arr1);
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            isArrayValid(arr2);
            castAndSum(arr2);
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    /**
     * if arr has size 4x4 - ok
     * else - throw MyArraySizeException
     * @param arr
     * @throws MyArraySizeException
     */
    private static void isArrayValid(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (String[] ar : arr) {
            if (ar.length != 4) {
                throw new MyArraySizeException();
            }
        }
    }

    /**
     * trying cast each element of array and sum
     * @param arr
     * @throws MyArrayDataException
     */
    private static void castAndSum(String[][] arr) throws MyArrayDataException {
        int res = 0;

        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                try {
                    res += Integer.valueOf(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }

        System.out.println("Result sum = "+res);


    }

}
