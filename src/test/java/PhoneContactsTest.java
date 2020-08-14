import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PhoneContactsTest {
    final String newGroup1 = "new Group1";
    final String newGroup2 = "new Group2";
    final Contact newContact1 = new Contact("new Contact 1", "111");
    final Contact newContact2 = new Contact("new Contact 2", "222");

    @BeforeEach
    public void startingTest() {
        System.out.println("- starting new test");
    }

    @Test
    void addGroupTest() {
        PhoneContacts phoneContacts = new PhoneContacts();
        phoneContacts.addGroup(newGroup1);
        phoneContacts.addGroup(newGroup2);

        Assertions.assertTrue(phoneContacts.getContactsMap().containsKey(newGroup1));
        Assertions.assertTrue(phoneContacts.getContactsMap().containsKey(newGroup2));

        assertThat(phoneContacts.getContactsMap(), hasKey(newGroup1));
        assertThat(phoneContacts.getContactsMap(), hasKey(newGroup2));
    }

    @Test
    void addContactTest() {
        PhoneContacts phoneContacts = new PhoneContacts();
        phoneContacts.addGroup(newGroup1);
        phoneContacts.addGroup(newGroup2);

        phoneContacts.addContact(newGroup1,newContact1);
        phoneContacts.addContact(newGroup1,newContact2);
        phoneContacts.addContact(newGroup2,newContact1);

        ArrayList<Contact> arrayContacts1 = new ArrayList<>();
        arrayContacts1.add(newContact1);
        arrayContacts1.add(newContact2);

        ArrayList<Contact> arrayContacts2 = new ArrayList<>();
        arrayContacts2.add(newContact1);

        Assertions.assertTrue(phoneContacts.getContactsMap().get(newGroup1).contains(newContact1));
        Assertions.assertTrue(phoneContacts.getContactsMap().get(newGroup1).contains(newContact2));
        Assertions.assertTrue(phoneContacts.getContactsMap().get(newGroup2).contains(newContact1));
        Assertions.assertFalse(phoneContacts.getContactsMap().get(newGroup2).contains(newContact2));

        assertThat(phoneContacts.getContactsMap(), hasEntry(newGroup1, arrayContacts1));
        assertThat(phoneContacts.getContactsMap(), hasEntry(newGroup2, arrayContacts2));
        assertThat(phoneContacts.getContactsMap(), not(hasEntry(newGroup2, arrayContacts1)));
    }
}
