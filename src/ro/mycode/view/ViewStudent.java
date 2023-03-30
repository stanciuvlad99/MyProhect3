package ro.mycode.view;

import ro.mycode.controllers.ControlApply;
import ro.mycode.controllers.ControlJob;
import ro.mycode.controllers.ControlStudent;
import ro.mycode.controllers.ControlStudies;
import ro.mycode.models.Apply;
import ro.mycode.models.Job;
import ro.mycode.models.Student;
import ro.mycode.models.Studies;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {
    private Student student;
    private ControlStudies controlStudies;
    private ControlApply controlApply;
    private ControlJob controlJob;

    public ViewStudent(Student student) {
        this.student = student;
        this.controlStudies = new ControlStudies();
        this.controlJob = new ControlJob();
        this.controlApply = new ControlApply();
        play();
    }

    private void menu() {
        System.out.println("Bine ai venit" + " " + student.getFirstName() + " " +student.getLastName() + " !");
        System.out.println();
        System.out.println("Apasati tasta 1 pentru a vedea toate joburile");
        System.out.println("Apasati tasta 2 pentru a vedea joburile la care ati aplicat");
        System.out.println("Apasati tasta 3 pentru a aplica la un job");
        System.out.println("Apasati tasta 4 pentru a renunta la aplicarea la un curs");
        System.out.println("Apasati tasta 5 pentru a vedea studiile dumneavoastra");
        System.out.println("Apasati tasta 6 pentru a adauga un studii la profilul dumneavoastra");
        System.out.println("Apasati tasta 7 pentru a elimina studii");
        System.out.println("Apasati tasta 8 pentru a face update studiilor");
        System.out.println("Apasati tasta 9 pentru a vedea cel mai frecventat job");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareJoburi();
                    break;
                case 2:
                    aplicariJoburi();
                    break;
                case 3:
                    aplicareJob();
                    break;
                case 4:
                    eliminareAplicare();
                    break;
                case 5:
                    studiiPorprii();
                    break;
                case 6:
                    adaugareStudii();
                    break;
                case 7:
                    eliminareStudii();
                    break;
                case 8:
                    update();
                    break;
                case 9:jobFrecventat();
                break;
                default:
                    break;
            }
        }
    }

    private void afisareJoburi() {
        controlJob.read();
    }

    private void aplicariJoburi() {
        ArrayList<Apply> applies = controlApply.aplcariPersonale(student.getStudentId());
        for (int i = 0; i < applies.size(); i++) {
            Job job = controlJob.findById(applies.get(i).getJobId());
            System.out.println(job.descriere());
        }
    }

    private void aplicareJob() {
        System.out.println("Introduceti numele jobului");
        Scanner scanner = new Scanner(System.in);
        String nume = scanner.nextLine();
        Job job = controlJob.findByName(nume);
        if (job != null) {
            Apply apply = controlApply.findByStudentIdJobId(student.getStudentId(), job.getJobId());
            if (apply != null) {
                System.out.println("Ati aplicat deja la acest job");
            } else {
                Apply apply1 = new Apply(controlApply.nextId(), student.getStudentId(), job.getJobId());
                controlApply.add(apply1);
                System.out.println("Ati aplicat cu succes la acest job");
            }
        } else {
            System.out.println(nume + " nu exista in baza de date");
        }
    }

    private void eliminareAplicare() {
        System.out.println("Introduceti numele jobului");
        Scanner scanner = new Scanner(System.in);
        String nume = scanner.nextLine();
        Job job = controlJob.findByName(nume);
        if (job != null) {
            Apply apply = controlApply.findByStudentIdJobId(student.getStudentId(), job.getJobId());
            if (apply != null) {
                controlApply.remove(apply);
                System.out.println("Ati anulat aplicrea la job");
            } else {
                System.out.println("Nu ati aplicat la acest job");
            }
        } else {
            System.out.println(nume + " nu exista in baza de date");
        }
    }

    private void studiiPorprii() {
        ArrayList<Studies> studies = controlStudies.studiiPersonale(student.getStudentId());
        for (int i = 0; i < studies.size(); i++) {
            Studies studies1 = controlStudies.findByStudiesId(studies.get(i).getStudiesId());
            System.out.println(studies1.descriere());
        }
    }

    private void adaugareStudii() {
        System.out.println("Inrooduceti numele facultatii/cursului");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Introduceti departamentulu");
        String department = scanner.nextLine();
        System.out.println("Introduceti anul finalizarii studiilor");
        int year = Integer.parseInt(scanner.nextLine());
        Studies studies = new Studies(controlStudies.nextId(), student.getStudentId(), name, department, year);
        controlStudies.add(studies);
        System.out.println("Ati adugat studiile cu succes");
    }

    private void eliminareStudii() {
        System.out.println("Introduceti numele studiilor");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Studies studies = controlStudies.findByNameStudentId(name, student.getStudentId());
        if (studies != null) {
            controlStudies.remove(studies);
            System.out.println("Studiile au fost eliminate");
        } else {
            System.out.println(name + "Nu exista in baza de date");
        }
    }

    private void update() {
        System.out.println("Introduceti numele studiilor");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Studies studies = controlStudies.findByNameStudentId(name, student.getStudentId());
        if (studies != null) {
            System.out.println("Introduceti departamentul");
            String department = scanner.nextLine();
            System.out.println("Introduceti anul finalizarii studiilor");
            int year = Integer.parseInt(scanner.nextLine());
            Studies studies1 = new Studies(studies.getStudiesId(), student.getStudentId(), studies.getName(),
                    department, year);
            controlStudies.update(studies1);
            System.out.println("Ati facut update cu succes");
        } else {
            System.out.println(name + " nu exista in profilul dumneavoastra");
        }
    }

    private void jobFrecventat(){
        Job job = controlJob.findById(controlApply.idJobFrecventat());
        System.out.println(job.descriere());
    }
}
