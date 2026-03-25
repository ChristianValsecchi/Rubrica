import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AddressBook ab;
        try {
            ab = new AddressBook();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ab.add(new Contact("SlavicSaviour", "4444444", "saveEvrope141@bombarbandaryovkij.ru"));
        ab.add(new Contact("FranzFerdinand", "1912648", "sarajevoMyReflection1914@archduke.auhu"));
        ab.add(new Contact("PanzerKriegKommander", "88888888", "EinHimm116188@ubergruppenfuhrer.re"));
        ab.add(new Contact("AliKhamenei", "0986174", "ayatollah<3@islamicPersia.ir"));

        for (Contact c : ab.getContactList()) System.out.println(c.toString());
    }
}

