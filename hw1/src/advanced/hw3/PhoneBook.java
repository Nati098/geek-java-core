package advanced.hw3;

import java.util.*;

public class PhoneBook {
    Map<String, List<Contact>> list = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (list.containsKey(surname)) {
            list.get(surname).add(new Contact(phoneNumber));
        }
        else {
            list.put(surname, new ArrayList<>(Collections.singletonList(new Contact(phoneNumber))));
        }
    }

    public List<Contact> get(String surname) {
        return list.getOrDefault(surname, null);
    }

}
