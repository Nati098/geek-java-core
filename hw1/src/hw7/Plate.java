package hw7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount) {
        if (isDecreaseEnabled(amount)) {
            food -= amount;
            return true;
        }
        return false;
    }

    private boolean isDecreaseEnabled(int amount) {
        return food-amount >= 0;
    }

    @Override
    public String toString() {
        return "Plate {" + "food=" + food + "}";
    }
}
