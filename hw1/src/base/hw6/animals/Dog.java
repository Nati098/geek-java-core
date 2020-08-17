package base.hw6.animals;

public class Dog extends Animal {
    private final int RUN_THRESHOLD = 500;
    private final int SWIM_THRESHOLD = 10;

    public Dog(String name, int age) {
        super(name, age);
        setThresholds(RUN_THRESHOLD, SWIM_THRESHOLD);
    }

}
