package professional.hw5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore capacitySem;

    public Tunnel(Semaphore capacity) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.capacitySem = capacity;
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                capacitySem.acquire();

                System.out.println(c.getName() + " начал этап: " + description + ". Свободных мест в тоннеле: " + capacitySem.availablePermits());
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                capacitySem.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
