package base.hw3;

import java.util.Random;
import java.util.Scanner;

/**
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
 * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
 * apple – загаданное, apricot - ответ игрока
 * ---> ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 */
public class GuessWordGame {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        String word = getRandomWord(words.length, 0);
        String hiddenWord = "###############";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Попробуйте угадать слово: ");
        while (true) {
            String ans = scanner.nextLine();

            if (ans.equals(word)) {
                break;
            }

            if (stringContainsUppercase(ans)) {
                System.out.print("\nИспользуйте только маленькие буквы!\nВы угадали:" + hiddenWord + "\nПопробуйте еще раз: ");
                continue;
            }

            hiddenWord = openRightSymbols(word, ans, hiddenWord);
            System.out.print("\nВы угадали:" + hiddenWord + "\nПопробуйте еще раз: ");

        }

        System.out.println("\nВы угадали!");
        scanner.close();
    }

    public static String getRandomWord(int bound, int shift) {
        Random random = new Random();
        return words[random.nextInt(bound) - shift];
    }

    public static boolean stringContainsUppercase(String s) {
        return !s.equals(s.toLowerCase());
    }

    public static String openRightSymbols(String right, String answer, String hidden) {
        StringBuilder sb = new StringBuilder(hidden);
        int length = Math.min(right.length(), answer.length());

        for (int i = 0; i < length; i++) {
            if (right.charAt(i) == answer.charAt(i)) {
                sb.replace(i, i + 1, Character.toString(answer.charAt(i)));
            }
        }

        return sb.toString();
    }
}
