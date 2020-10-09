package professional.hw1.task3;

public class Orange extends Fruit {
    private float weight = 1.5f;

    public Orange() {}

    public Orange(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "w=" + weight +
                '}';
    }
}
