import java.util.*;
import java.util.Map.Entry;

public class PhoneContacts {

    private Map<String, ArrayList<Contact>> contactsMap;

    public PhoneContacts() {
        contactsMap = new HashMap<>();
    }

    public void addGroup(String newGroup) {
        this.contactsMap.put(newGroup, new ArrayList<>());
    }

    public void addContact(String group, Contact contact) {
        if (contactsMap.containsKey(group)) {
            int index = Collections.binarySearch(contactsMap.get(group),contact);
            index = Math.abs(index)-1;
            contactsMap.get(group).add(index,contact);
        } else {
            System.out.println("Такой группы не найдено");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Телефонная книга:\n");
        Set<Entry<String, ArrayList<Contact>>> entries = contactsMap.entrySet();
        for (Entry<String, ArrayList<Contact>> groupContacts: entries) {
            stringBuilder
                    .append(groupContacts.getKey())
                    .append("\n");
            for (Contact contact :groupContacts.getValue()) {
                stringBuilder
                        .append(contact.getName())
                        .append(" ")
                        .append(contact.getPhoneNumber())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public Map<String, ArrayList<Contact>> getContactsMap() {
        return contactsMap;
    }
}
