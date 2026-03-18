import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AddressBook ab;
        try {
            ab = new AddressBook();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Contact c : ab.getContactList()) System.out.println(c.toString());
    }
}

