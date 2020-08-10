package hw7;

import static hw6.Data.*;

public class JavaApp {
    public static void main(String[] args) {


        Cat[] cats = {
                new Cat(CATS_NAME[0]),
                new Cat(CATS_NAME[1], 5),
                new Cat(CATS_NAME[2]),
                new Cat(CATS_NAME[3], 8),
                new Cat(CATS_NAME[4]),
        };

        Plate plate = new Plate(45);

        System.out.println("Cats begin eating");
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        System.out.println("\nWell fed cats:");
        for (Cat cat : cats) {
            if (cat.isFullness()) {
                System.out.println("Cat " + cat.getName() + " is well fed");
            }
            else {
                System.out.println("Cat " + cat.getName() + " isn't well fed");
            }

        }


    }

}
