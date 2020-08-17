package base.hw5;

public class Employee {
    private String fio;
    private String post;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fio, String post, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.printf("Сотрудник:\n%s, %d\n%s\n%s, %s\nSalary: %.2f\n",
                fio, age, post, phone, email, salary);
    }

    // 2й способ
    @Override
    public String toString() {
        return String.format("Сотрудник:\n%s, %d\n%s\n%s, %s\nSalary: %.2f\n",
                fio, age, post, phone, email, salary);
    }
}
