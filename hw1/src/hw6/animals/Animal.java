package hw6.animals;

public abstract class Animal {

    protected int runThreshold = 0;
    protected int swimThreshold = 0;

    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void setThresholds(int run, int swim) {
        this.runThreshold = run;
        this.swimThreshold = swim;
    }

    public void run(int distance) {
        if (distance > runThreshold) {
            System.out.print(String.format("%s не пробежит\n", name));
        }
        else {
            System.out.print(String.format("%s пробежал %d м\n", name, distance));
        }
    }

    public void swim(int distance) {
        if (distance > swimThreshold) {
            System.out.print(String.format("%s не поплывет\n", name));
        }
        else {
            System.out.print(String.format("%s проплыл %d м\n", name, distance));
        }
    }

    @Override
    public String toString() {
        return String.format("Animal:\n%s, %d\n", name, age);
    }
}
