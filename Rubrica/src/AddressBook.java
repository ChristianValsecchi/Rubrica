import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contactList;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public AddressBook () {
        contactList = new ArrayList<>();
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void add(Contact contact) {
        if (contact != null && !contactList.contains(contact))
            contactList.add(contact);

    }

    public void add() throws IOException {
        System.out.print("Insert contact name: ");
        String n = br.readLine();
        System.out.print("Insert contact surname: ");
        String s = br.readLine();
        System.out.print("Insert contact email: ");
        String e = br.readLine();
        System.out.print("Insert contact phone: ");
        String p = br.readLine();
        Contact contact = new Contact(n, s, e, p);

        if (!contactList.contains(contact))
            contactList.add(contact);

    }

    public void remove(Contact contact) {
        if (contact != null && !contactList.contains(contact))
            contactList.remove(contact);

    }

}
