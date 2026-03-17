public class Contact {
    private String name, surname, email, phone;

    public Contact (String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }
    public Contact (String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public Contact (String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return name+" "+surname+" "+phone+" "+email;
    }
}
