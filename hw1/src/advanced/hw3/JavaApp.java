package advanced.hw3;

import java.util.*;

public class JavaApp {
    static String[] words = {"apple", "avocado", "cherry", "mango", "peanut", "pepper", "pumpkin",
                                 "apple", "pepper", "cherry", "mango", "cherry", "mango", "peanut", "apple"};
    static String[] surnames = {"Apple", "Avocado", "Cherry", "Mango", "Peanut", "Pepper", "Pumpkin",
            "Apple", "Pepper", "Cherry", "Mango", "Cherry", "Mango", "Peanut", "Apple"};
    static String[] phones = {"89165554433", "89165557766", "89165559988", "89165557654", "89165559876",
            "89165555487", "89165559874", "89165550053", "89165556708", "89165552347", "89165557313",
            "89165559834", "89165550091", "89165552020", "89165556792"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        ArrayList<String> wordsArray = new ArrayList<>(Arrays.asList(words));
        Set<String> wordsSet = new LinkedHashSet<>(wordsArray);

        System.out.println("Initial words: " + wordsArray);
        System.out.println("Unique words: " + wordsSet);

        Map<String, Integer> wordsMap = new HashMap<>();
        wordsArray.forEach(word -> {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word)+1);
            }
            else {
                wordsMap.put(word, 1);
            }
        });

        System.out.println("Counted words: " + wordsMap);

    }

    public static void task2() {
        PhoneBook phoneBook = new PhoneBook();

        for (int i=0; i < surnames.length; i++) {
            phoneBook.add(surnames[i], phones[i]);
        }

        while (true) {
            System.out.print("\nSurname to search phone numbers: ");
            System.out.println("Result: " + getResultPhoneList(phoneBook.get(scanner.nextLine())));
        }

    }

    public static String getResultPhoneList(List<Contact> data) {
        if (data == null) {
            return "None";
        }

        StringBuilder res = new StringBuilder();
        for (Contact d : data) {
            res.append(d).append(" ");
        }
        return res.toString();
    }
}
