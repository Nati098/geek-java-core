package professional.hw1.task3;


import professional.hw1.CustomArray;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaApp {

    public static void main(String[] args) {
        tasks12();
        task3();
    }

    public static void tasks12() {
        CustomArray<String> arrStr = new CustomArray<>(new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado"});
        System.out.println(arrStr);
        arrStr.switchElements(5,7);
        arrStr.switchElements(5,1);
        System.out.println(arrStr);

        System.out.println();

        CustomArray<Integer> arrInt = new CustomArray<>(new Integer[]{11,13,21,132,7});
        System.out.println(arrInt);
        arrInt.switchElements(5,7);
        arrInt.switchElements(2,4);
        System.out.println(arrInt);

        System.out.println();

    }

    public static void task3() {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruits(new ArrayList<>(Arrays.asList(new Apple(),
                                                            new Apple(2.4f),
                                                            new Apple(1.6f),
                                                            new Apple())));
        System.out.println(appleBox1+"\nTotal weight = "+appleBox1.getWeight());
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruits(new ArrayList<>(Arrays.asList(new Apple(),
                                                            new Apple(1.6f),
                                                            new Apple())));
        System.out.println(appleBox2+"\nTotal weight = "+appleBox2.getWeight());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruits(new ArrayList<>(Arrays.asList(new Orange(),
                                                            new Orange(2.4f),
                                                            new Orange(1.6f),
                                                            new Orange())));
        System.out.println(orangeBox1+"\nTotal weight = "+orangeBox1.getWeight());
        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruits(new ArrayList<>(Arrays.asList(new Orange(3.4f),
                                                            new Orange(),
                                                            new Orange(0.6f),
                                                            new Orange())));
        System.out.println(orangeBox2+"\nTotal weight = "+orangeBox2.getWeight());

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(orangeBox2.compare(orangeBox1));

        appleBox1.putFruitsIn(appleBox2);
        System.out.println(appleBox1);
        System.out.println(appleBox2);

    }


}
