package ro.mycode.models;

public class Studies {
    private int studiesId = 0;
    private int studentId = 0;
    private String name = "";
    private String department = "";
    private int year = 0;

    public Studies(int studiesId, int studentId, String name, String department, int year) {
        this.studiesId = studiesId;
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.year = year;
    }

    public Studies(String text) {
        String[] split = text.split(",");
        this.studiesId = Integer.parseInt(split[0]);
        this.studentId = Integer.parseInt(split[1]);
        this.name = split[2];
        this.department = split[3];
        this.year = Integer.parseInt(split[4]);
    }

    public int getStudiesId() {
        return studiesId;
    }

    public void setStudiesId(int studiesId) {
        this.studiesId = studiesId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String descriere() {
        String descreire = "Id-ul studiului este " + studiesId + ", numele scolii/cursului este " + name +
                ", departamentul este " + department + ", iar anul finalizarii este " + year;
        return descreire;
    }
}
