package hw6.animals;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
        setThresholds(200, 0);
    }

}
