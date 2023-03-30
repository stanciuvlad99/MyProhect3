package ro.mycode.view;

import ro.mycode.controllers.ControlAdmin;
import ro.mycode.controllers.ControlStudent;
import ro.mycode.models.Admin;
import ro.mycode.models.Student;

import java.util.Scanner;

public class ViewLogin {
    private ControlStudent controlStudent;
    private ControlAdmin controlAdmin;

    public ViewLogin() {
        this.controlStudent = new ControlStudent();
        this.controlAdmin = new ControlAdmin();
        login();
    }


    public void login() {
        System.out.println("Inreoduceti adresa de mail");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String password = scanner.nextLine();
        Admin admin = controlAdmin.findByEmailPassword(email, password);
        Student student = controlStudent.findByEmailPassword(email, password);
        if (admin != null) {
            ViewAdmin viewAdmin = new ViewAdmin(admin);
        }
        if (student != null) {
            ViewStudent viewStudent = new ViewStudent(student);
        }

    }
}
