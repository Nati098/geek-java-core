package advanced.hw1.main_task.objects;

import advanced.hw1.main_task.interfaces.Runnable;

public class Track {

    private int length;


    public Track(int length) {
        this.length = length;
    }


    public void run(Runnable r) {
        if (r.isCanRun(length)) {
            r.run(length);
        }
        else {
            System.out.println("Failed...");
        }
    }

}
