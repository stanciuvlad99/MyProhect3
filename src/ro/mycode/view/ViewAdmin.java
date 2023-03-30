package ro.mycode.view;

import ro.mycode.controllers.ControlApply;
import ro.mycode.controllers.ControlJob;
import ro.mycode.controllers.ControlStudent;
import ro.mycode.models.Apply;
import ro.mycode.models.Job;
import ro.mycode.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAdmin {
    private ControlApply controlApply;
    private ControlStudent controlStudent;
    private ControlJob controlJob;

    public ViewAdmin() {
        this.controlApply=new ControlApply();
        this.controlStudent = new ControlStudent();
        this.controlJob = new ControlJob();
        play();
    }

    public void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea toti studentii");
        System.out.println("Apasati tasta 2 pentru a adauga un student in baza de date");
        System.out.println("Apasati tasta 3 pentru a elimina un student din baza de date");
        System.out.println("Apasati tasta 4 pentru a vedea toate joburile");
        System.out.println("Apasati tasta 5 pentru a adauga un job in baza de date");
        System.out.println("Apasati tasta 6 pentru a elimina un job din lista");
        System.out.println("Apasati tasta 7 pentru a face update");
        System.out.println("Apasati tasta 8 pentru a vedea studiile unui student");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareStudenti();
                    break;
                case 2:
                    adaugareStudent();
                    break;
                case 3:
                    eliminareStudent();
                    break;
                case 4:
                    afisareJoburi();
                    break;
                case 5:
                    adaugareJob();
                    break;
                case 6:
                    elimnareJob();
                    break;
                case 7:updateJob();
                break;
                case 8:studiiStudent();
                break;
                default:
                    break;
            }
        }
    }

    private void afisareStudenti() {
        controlStudent.read();
    }

    private void adaugareStudent() {
        System.out.println("Introduceti prenumele");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Introduceti numele de familie");
        String lastName = scanner.nextLine();
        Student student = controlStudent.findByFirstNameLastName(firstName, lastName);
        if (student == null) {
            System.out.println("Introduceti varsta");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti adresa de mail");
            String email = scanner.nextLine();
            System.out.println("Introduceti parola");
            String password = scanner.nextLine();
            Student student1 = new Student(controlStudent.nextId(), firstName, lastName, age, email, password);
            controlStudent.add(student1);
            System.out.println("Studentul a fost adugat cu succes");
        } else {
            System.out.println(firstName + " " + lastName + " exista in baza de date");
        }
    }

    private void eliminareStudent() {
        System.out.println("Introduceti prenumele");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Introduceti numele de familie");
        String lastName = scanner.nextLine();
        Student student = controlStudent.findByFirstNameLastName(firstName, lastName);
        if (student != null) {
            controlStudent.remove(student);
            System.out.println("Studentul a fost eliminat din baza de date");
        } else {
            System.out.println(firstName + " " + lastName + " nu exista in baza de date");
        }
    }

    private void afisareJoburi() {
        controlJob.read();
    }

    private void adaugareJob() {
        System.out.println("Introduceti jobul");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Job job = controlJob.findByName(name);
        if (job == null) {
            System.out.println("Introduceti departamentul");
            String department = scanner.nextLine();
            Job job1 = new Job(controlJob.nextId(), name, department);
            controlJob.add(job1);
            System.out.println("Jobul a fost adugat cu succes");
        } else {
            System.out.println(name + " exista deja in baza de date");
        }
    }

    private void elimnareJob() {
        System.out.println("Introduceti numele jobului");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Job job = controlJob.findByName(name);
        if (job != null) {
            controlJob.remove(job);
            System.out.println("Jobul a fost eliminat cu succes");
        } else {
            System.out.println(name + " nu exist in baza de date");
        }
    }

    private void updateJob(){
        System.out.println("Introduceti numele Jobului");
        Scanner scanner = new Scanner(System.in);
        String name=scanner.nextLine();
        Job job = controlJob.findByName(name);
        if (job!=null){
            System.out.println("Introduceti noul nume al jobului");
            String newName=scanner.nextLine();
            controlJob.updateName(new Job(job.getJobId(), newName, job.getDepartment()));
            System.out.println("Introduceti noul departament");
            String newDepartment=scanner.nextLine();
            System.out.println("Introduceti noul id");
            int newId=Integer.parseInt(scanner.nextLine());
            controlJob.updateIdDepartment(new Job(newId, job.getName(), newDepartment));
            System.out.println("Ati facut update jobului cu succes");
        }else {
            System.out.println(name +" nu exista in baza de date");
        }
    }

    private void studiiStudent(){
        System.out.println("Introduceti prenumele studentului");
        Scanner scanner = new Scanner(System.in);
        String firstName=scanner.nextLine();
        System.out.println("Introduceti numele de familie al studentului");
        String lastName=scanner.nextLine();
        Student student = controlStudent.findByFirstNameLastName(firstName,lastName);
        if (student!=null){
            ArrayList<Apply> applies = controlApply.aplcariPersonale(student.getStudentId());
            for (int i=0; i<applies.size(); i++){
                Job job = controlJob.findByJobId(applies.get(i).getJobId());
                System.out.println(job.descriere());
            }
        }else {
            System.out.println(firstName +" "+ lastName + " nu exista in baza de date");
        }
    }
}
