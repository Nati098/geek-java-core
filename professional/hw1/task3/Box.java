package professional.hw1.task3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public float getWeight() {
        float res = 0.0f;
        for (T fruit : fruits) {
            res += fruit.getWeight();
        }
        return res;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.000001;
    }

    public void putFruitsIn(Box<T> box) {
        box.addFruits(this.fruits);
        this.fruits.clear();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Box: ");
        for (Fruit fruit : fruits) {
            res.append(fruit + " -> ");
        }
        res.append("|");
        return res.toString();
    }
}
