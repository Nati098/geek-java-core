package advanced.hw1.main_task.objects;

import advanced.hw1.main_task.interfaces.Jumpable;

public class Wall {

    private double height;


    public Wall(double height) {
        this.height = height;
    }


    public void jumpThrough(Jumpable j) {
        if (j.isCanJump(height)) {
            j.jump(height);
        }
        else {
            System.out.println("Failed...");
        }
    }

}
