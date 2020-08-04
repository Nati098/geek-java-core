package hw5;

import static hw5.Data.*;

public class JavaApp {

    public static void main(String[] args) {
        int size = 5;
        Employee[] persArray = new Employee[size];
        for (int i=0; i < size; i++) {
            persArray[i] = new Employee(FIOS[i], POSTS[i], EMAILS[i], PHONES[i], SALARIES[i], AGES[i]);
        }

        System.out.println("Сотрудники страше 40 лет:");
        int count = 1;
        int ageThreshold = 40;
        for (Employee employee : persArray) {
            if (employee.getAge() >= ageThreshold) {
                System.out.print(count + ")");
                employee.printInfo();
                System.out.println();
                count++;
            }
        }

    }

}
