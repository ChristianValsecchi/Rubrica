import java.io.*;
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contactList;
    private File contactFile;
    private BufferedReader keyboard;
    private BufferedReader reader;

    public AddressBook () throws IOException {
        contactList = new ArrayList<>();
        contactFile = new File("X:\\Users\\valsecchi.christian\\Desktop\\contatti.txt");
        if (!contactFile.exists())
            contactFile.createNewFile();

        keyboard = new BufferedReader(new InputStreamReader(System.in));
        reader = new BufferedReader(new FileReader(contactFile));
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void add(Contact contact) {
        if (contact != null && !contactList.contains(contact))
            contactList.add(contact);
        save();

    }

    public void add() throws IOException {
        System.out.print("Insert contact name: ");
        String n = keyboard.readLine();
        System.out.print("Insert contact surname: ");
        String s = keyboard.readLine();
        System.out.print("Insert contact email: ");
        String e = keyboard.readLine();
        System.out.print("Insert contact phone: ");
        String p = keyboard.readLine();
        Contact contact = new Contact(n, s, e, p);
        keyboard.close();

        if (!contactList.contains(contact))
            contactList.add(contact);

        save();
    }

    public void remove(Contact contact) {
        if (contact != null && !contactList.contains(contact))
            contactList.remove(contact);
        save();
    }

    private void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(contactFile))) {
            for (Contact c : contactList)
                writer.println(contactList.indexOf(c) + ": " + c.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Impossibile salvare contatto: " + e.getMessage());

        }
    }

    public void print() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) System.out.println(line);
        reader.close();
    }

}
