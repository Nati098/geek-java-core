package base.hw3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    static Scanner sc = new Scanner(System.in);
    static int lifes = 3;

    public static void main(String[] args) {
        do {
            playGame();
        }
        while (sc.nextInt() != 0);
    }

    public static int getRandomNumber(int bound, int shift) {
        Random random = new Random();
        return random.nextInt(bound) - shift;
    }

    public static void playGame() {
        int num = getRandomNumber(10, 0);
        lifes = 3;

        System.out.print("\nПопробуйте угадать число от 0 до 9. У вас " + lifes + " попытки: ");
        while (lifes > 0) {
            int ans = sc.nextInt();

            if (ans == num) {
                System.out.println("Вы угадали! Повторить игру еще раз? (1 – да / 0 – нет)");
                return;
            }

            lifes--;
            System.out.print("У вас осталось попыток: " + lifes + ". Попробуйте еще раз: ");
        }
        System.out.println("У вас больше нет попыток. Повторить игру еще раз? (1 – да / 0 – нет)");
    }

}
