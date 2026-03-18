import java.io.*;
import java.util.ArrayList;
//X:\Users\valsecchi.christian\Desktop\
public class AddressBook {
    private ArrayList<Contact> contactList;
    private File contactFile;

    public AddressBook () throws IOException {
        contactFile = new File("X:\\Users\\valsecchi.christian\\Desktop\\contatti.txt");
        if (!contactFile.exists()) {
            contactFile.createNewFile();
            contactList = new ArrayList<>();
        }

        contactList = read();

    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void add(Contact contact) {
        if (contact != null && !contactList.contains(contact))
            contactList.add(contact);
        write();

    }

    public void add() throws IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert contact name: ");
        String n = keyboard.readLine();
        System.out.print("Insert contact email: ");
        String e = keyboard.readLine();
        System.out.print("Insert contact phone: ");
        String p = keyboard.readLine();
        Contact contact = new Contact(n, e, p);
        keyboard.close();

        if (!contactList.contains(contact))
            contactList.add(contact);

        write();
    }

    public void remove(Contact contact) {
        if (contact != null && !contactList.contains(contact))
            contactList.remove(contact);
        write();
    }

    private void write() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(contactFile))) {
            for (Contact c : contactList)
                writer.println(c.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Impossibile salvare contatto: " + e.getMessage());

        }
    }
    private ArrayList<Contact> read() {
        ArrayList<Contact> contactList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(contactFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contact contact = parseContact(line);
                if (contact != null && !contactList.contains(contact)) contactList.add(contact);
            }
        } catch (IOException e) {
            System.out.println("Impossibile leggere il file: "+e.getMessage());
        }
        return contactList;
    }
    private Contact parseContact(String line) {
        String[] parts = line.split("\\|", -1); // Preserve empty fields
        if (parts.length < 2) return null;

        String name = parts[0].trim();
        String phone = parts[1].trim();
        String email = parts.length > 2 ? parts[2].trim() : null;
        email = email.isEmpty() ? null : email;

        return new Contact(name, phone, email);
    }

}
