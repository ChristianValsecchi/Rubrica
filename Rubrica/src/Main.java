import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AddressBook ab;
        try {
            ab = new AddressBook();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ab.print();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

