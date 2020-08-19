package advanced.hw1.enum_task;

public class DayOfWeekMain {

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
    }

    private static String getWorkingHours(DayOfWeek d) {
        if (d.getWorkHours() == 0) {
            return "Today is a holiday";
        }

        int res = 0;
        for (DayOfWeek dow : DayOfWeek.values()) {
            res += dow.compareTo(d) < 0 ? 0 : dow.getWorkHours();
        }

        return String.format("Remained %d hours", res);
    }

}
