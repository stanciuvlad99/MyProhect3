package ro.mycode;

import ro.mycode.controllers.*;
import ro.mycode.models.*;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewLogin;
import ro.mycode.view.ViewStudent;

public class Main {
    public static void main(String[] args) {

        ViewLogin viewLogin = new ViewLogin();
        System.out.println(viewLogin);

//        ControlStudies controlStudies = new ControlStudies();
//        controlStudies.add(new Studies("10,10,Facultatea de Farmacie,Medical,2023"));
//        controlStudies.save();

//        ControlJob controlJob = new ControlJob();
//        controlJob.add(new Job("10,Farmacist,Medical"));
//        controlJob.save();

//        ControlStudent controlStudent = new ControlStudent();
//        controlStudent.add(new Student("10,Ioana,Vasilescu,25,ioana.vasilescu@email.com,10an4V4sil3scu"));
//        controlStudent.save();

//        ControlApply controlApply = new ControlApply();
//        controlApply.add(new Apply("10,10,10"));
//        controlApply.save();

//        ControlAdmin controlAdmin = new ControlAdmin();
//        controlAdmin.add(new Admin("10,iustinstan@hotmail.com,tgbyhnujm12,Iustin,Stann"));
//        controlAdmin.save();
    }
}