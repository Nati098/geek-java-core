package professional.hw1.task3;

public class Apple extends Fruit {
    private float weight = 1.0f;

    public Apple() {}

    public Apple(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "w=" + weight +
                '}';
    }
}
