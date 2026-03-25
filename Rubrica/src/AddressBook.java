import java.io.*;
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contactList;
    private final File contactFile = new File("Rubrica/contatti.txt");

    public AddressBook () throws IOException {
        if (!contactFile.exists()) contactFile.createNewFile();
        else contactList = read();
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void add(Contact contact) {
        contactList = read();

        if (contact != null && !contactList.contains(contact)) {
            contactList.add(contact);
            write(contact);
        }
    }

    public void add() throws IOException {
        contactList = read();

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert contact name: ");
        String n = keyboard.readLine();
        System.out.print("Insert contact email: ");
        String e = keyboard.readLine();
        System.out.print("Insert contact phone: ");
        String p = keyboard.readLine();
        Contact contact = new Contact(n, e, p);
        keyboard.close();

        if (!contactList.contains(contact)) {
            contactList.add(contact);
            write(contact);
        }

    }

    public void remove(Contact contact) {
        contactList = read();

        if (contact != null && !contactList.contains(contact))
            contactList.remove(contact);
        write();
    }

    private void write(Contact contact) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactFile, true))) {
            writer.write(contact.toString()+"\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Impossibile salvare contatto: " + e.getMessage());
        }
    }

    private void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactFile))) {
            for (Contact c : contactList)
                writer.write(c.toString()+"\n");
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
        String[] parts = line.split("\\|", -1);
        if (parts.length < 2) return null;

        String name = parts[0].trim();
        String phone = parts[1].trim();
        String email = parts.length > 2 ? parts[2].trim() : null;
        email = email.isEmpty() ? null : email;

        return new Contact(name, phone, email);
    }

}
