package advanced.hw1.main_task.objects;

import advanced.hw1.main_task.interfaces.Combined;

public class Cat implements Combined {
    private int capableDistance = 1000;
    private double capableHeight = 2.3;

    private String name;


    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int capableDistance, double capableHeight) {
        this.name = name;
        this.capableDistance = capableDistance;
        this.capableHeight = capableHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void jump(double h) {
        System.out.println("Cat " + name + " jumped " + h + " m");
    }

    @Override
    public void run(int d) {
        System.out.println("Cat " + name + " ran " + d + " m");
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
