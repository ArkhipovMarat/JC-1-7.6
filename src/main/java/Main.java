import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneContacts phoneContacts = new PhoneContacts();
        Scanner scanner = new Scanner(System.in);

        inputGroup(phoneContacts, scanner);

        while (true) {
            inputContacts(phoneContacts, scanner);
            System.out.println("Завершить - 1, продолжить - 2");
            if (scanner.nextLine().equals("1")) break;
        }
        System.out.println(phoneContacts);
    }


    public static void inputGroup(PhoneContacts phoneContacts, Scanner scanner) {
        while (true) {
            System.out.println("Введите название новой группы или введите '1', чтобы завершить");
            String input = scanner.nextLine();
            if (input.equals("1")) break;
            phoneContacts.addGroup(input);
        }
    }

    public static void inputContacts(PhoneContacts phoneContacts, Scanner scanner) {
        System.out.println("Создайте новый контакт - через пробел введите имя и номер телефона");
        String[] subStrContacts = scanner.nextLine().split(" ");
        Contact contact = new Contact(subStrContacts[0], subStrContacts[1]);

        System.out.println("Введите название групп через пробел, в которые нужно добавить данный контакт");
        String[] subStrGroups = scanner.nextLine().split(" ");

        for (int i = 0; i < subStrGroups.length; i++) {
            phoneContacts.addContact(subStrGroups[i], contact);
        }
    }
}

