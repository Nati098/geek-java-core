package base.hw1;

public class JavaApp {
    public static void main(String[] args) {
        byte v1 = 126;
        short v2 = 12020;
        int v3 = 332020;
        long v4 = 12345678910L;
        float v5 = 3.14f;
        double v6 = 3.14;
        char v7 = 'c';
        boolean v8 = true;

        System.out.println(calculate(2, 2, 3.14f, 3.14f));

        System.out.println(task10and20(5, 6));
        System.out.println(task10and20(15, 6));

        isPositiveOrNegative(-30);
        isPositiveOrNegative(0);

        System.out.println(isNegative(-30));
        System.out.println(isNegative(0));

        greetings("Mark");

        System.out.println(isLeapYear(1700));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2020));
    }

    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task10and20(int x1, int x2) {
        return (10 <= (x1+x2)) && ((x1+x2) <= 20);
    }

    public static void isPositiveOrNegative(int x) {
        if (x < 0) {
            System.out.println("Отрицательное");
        }
        else {
            System.out.println("Положительное");
        }
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static void greetings(String name) {
        System.out.printf("Hello, %s!\n", name);
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else
            return (year % 4 == 0);
    }
}
