public class Contact {
    private String name, email, phone;

    public Contact (String name, String phone, String email) {
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
        String email = this.email;
        if (this.email == null) {
            email = "";
        }
        return name+"|"+phone+"|"+email;
    }
}
