package ro.mycode.models;

public class Student {
    private int studentId = 0;
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
    private String email = "";
    private String password = "";

    public Student(String text) {
        String[] split = text.split(",");
        this.studentId = Integer.parseInt(split[0]);
        this.firstName = split[1];
        this.lastName = split[2];
        this.age = Integer.parseInt(split[3]);
        this.email = split[4];
        this.password = split[5];
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String descriere() {
        String descriere = "Id-ul studentului este " + studentId + ", prenumele si numele sunt " + firstName + " " +
                lastName + ", varsta este " + age + " ani" + ", iar adresa de mail si parola sunt " + email + " "
                + password;
        return descriere;
    }
}
