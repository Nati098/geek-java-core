package advanced.hw1.main_task.objects;

import advanced.hw1.main_task.interfaces.Combined;

public class Human implements Combined {

    private int capableDistance = 5000;
    private double capableHeight = 2.0;

    private String name;


    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int capableDistance, double capableHeight) {
        this.name = name;
        this.capableDistance = capableDistance;
        this.capableHeight = capableHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void jump(double h) {
        System.out.println("Human " + name + " jumped " + h + " m");
    }

    @Override
    public void run(int d) {
        System.out.println("Human " + name + " ran " + d + " m");
    }

    @Override
    public boolean isCanJump(double h) {
        return h <= capableHeight;
    }

    @Override
    public boolean isCanRun(int d) {
        return d <= capableDistance;
    }
}
