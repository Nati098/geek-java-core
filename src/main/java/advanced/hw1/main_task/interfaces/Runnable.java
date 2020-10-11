package advanced.hw1.main_task.interfaces;

public interface Runnable {
    public default void run(int d) {
        System.out.println("Object ran "+d+" m");
    }
    public boolean isCanRun(int d);
}
