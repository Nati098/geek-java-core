package advanced.hw1.main_task;

import advanced.hw1.main_task.interfaces.Combined;
import advanced.hw1.main_task.objects.*;

public class JavaApp {

    public static void main(String[] args) {

        Track[] tracks = {
                new Track(100),
                new Track(1000),
                new Track(10000),
                new Track(5000)
        };
        Wall[] walls = {
                new Wall(0.5),
                new Wall(1),
                new Wall(2.34),
                new Wall(5),
        };

        Combined[] objects = {
                new Human("Alex", 6000, 1.4),
                new Human("Sam"),
                new Cat("Maiko", 1200, 1.9),
                new Cat("Nosferatu"),
                new Robot("M1457", 150, 0),
                new Robot("GTX6", 1200, 1.8)
        };

        for (Combined o : objects) {
            for (Track t : tracks) {
                t.run(o);
            }

            for (Wall w : walls) {
                w.jumpThrough(o);
            }

            System.out.println();
        }
    }

}
