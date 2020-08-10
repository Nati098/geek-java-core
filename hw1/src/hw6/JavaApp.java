package hw6;

import hw6.animals.Animal;
import hw6.animals.Cat;
import hw6.animals.Dog;

import static hw6.Data.*;

public class JavaApp {

    public static void main(String[] args) {
        int n = 5;  // the number of 1 type of animals
        Animal[] animals = {
                new Cat(CATS_NAME[0], CATS_AGE[0]),
                new Cat(CATS_NAME[1], CATS_AGE[1]),
                new Cat(CATS_NAME[2], CATS_AGE[2]),
                new Cat(CATS_NAME[3], CATS_AGE[3]),
                new Dog(DOGS_NAME[0], DOGS_AGE[0]),
                new Dog(DOGS_NAME[1], DOGS_AGE[1]),
                new Dog(DOGS_NAME[2], DOGS_AGE[2])
        };

        System.out.println("Число котов: "+countAnimals(animals, Cat.class));
        System.out.println("Число собак: "+countAnimals(animals, Dog.class));

        Cat cat = new Cat(CATS_NAME[4], CATS_AGE[4]);
        cat.run(100);
        cat.swim(5);

        Dog dog = new Dog(DOGS_NAME[3], DOGS_AGE[3]);
        dog.run(700);
        dog.swim(5);

    }

    /**
     *
     * @param animals - array of animals
     * @param clazz - required kind of animal
     * @return res - number of animals of the class
     */
    public static int countAnimals(Animal[] animals, Class clazz) {
        int res = 0;
        for (Animal animal : animals) {
            if (clazz.isInstance(animal)) {
                res++;
            }
        }
        return res;
    }

}
