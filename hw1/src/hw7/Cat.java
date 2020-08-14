package hw7;

public class Cat {
    private String name;
    private boolean fullness = false;

    private int neededFood = 10;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int food) {
        this.name = name;
        this.neededFood = food;
    }

    public String getName() {
        return name;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void eat(Plate plate) {
        System.out.println(name + "is trying to eat " + neededFood + " points");
        if (plate.decreaseFood(neededFood)) {
            this.fullness = true;
            System.out.println("Success! Balance: " + plate.getFood() + " points");
        }
        System.out.println("Not enough food! Balance: " + plate.getFood() + " points");
    }

}
