package ro.mycode.models;

public class Admin {
    private int adminId = 0;
    private String email = "";
    private String password = "";
    private String firstName = "";
    private String lastName = "";

    public Admin(String text) {
        String[] split = text.split(",");
        this.adminId = Integer.parseInt(split[0]);
        this.email = split[1];
        this.password = split[2];
        this.firstName = split[3];
        this.lastName = split[4];
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String descriere() {
        String descriere = "Id-ul adminului este " + adminId + ", prenumele si numele sunt " + firstName + " " +
                lastName + ", iar adresa de mail si parola sunt " + email + " " + password;
        return descriere;
    }

    public String toSave() {
        return this.adminId + "," + this.email + "," + this.password + "," + this.firstName + "," + this.lastName + ",";
    }
}
