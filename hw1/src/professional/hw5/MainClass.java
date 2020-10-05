package professional.hw5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;


public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final AtomicBoolean isFirstFinished = new AtomicBoolean(false);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

//    TODO    Semaphore sem = new Semaphore(CARS_COUNT / 2);

        ArrayBlockingQueue<Race> abq = new ArrayBlockingQueue<>(1);
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);

        //prepare race
        new Thread(()-> {
            try {
                Race race = new Race(new Road(60), new Tunnel(), new Road(40));
                abq.put(race);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("Трасса подготовлена");
            }
        }).start();

        // prepare cars
        Car[] cars = new Car[CARS_COUNT];
        new Thread(()-> {
            CyclicBarrier cb = new CyclicBarrier(CARS_COUNT, () -> startRace());

            try {
                Race race = abq.take();
                for (int i = 0; i < cars.length; i++) {
                    cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdl);
                }

                for (int i = 0; i < cars.length; i++) {
                    new Thread(cars[i]).start();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static void startRace() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }

}
