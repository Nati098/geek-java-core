package advanced.hw1.enum_task;

public enum DayOfWeek {
    MONDAY(9), TUESDAY(9), WEDNESDAY(9),
    THURSDAY(9), FRIDAY(9), SATURDAY(0), SUNDAY(0);

    private int workHours;

     DayOfWeek(int hours) {
        this.workHours = hours;
     }

     public int getWorkHours() {
         return workHours;
     }
}
