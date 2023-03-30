package ro.mycode.controllers;

import ro.mycode.models.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlStudent {
    private ArrayList<Student> students;
    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\student";

    public ControlStudent(){
        this.students=new ArrayList<>();
        load();
    }

    private void load() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Student student = new Student(text);
                this.students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toti studentii
    public void read(){
        for (int i=0; i<students.size(); i++){
            System.out.println(students.get(i).descriere());
        }
    }

    //todo: functie ce returneaza un student, primeste firstName si lastName ca parametru
    public Student findByFirstNameLastName(String firstName, String lastName){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)){
                return students.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (students.size()==0){
            return -1;
        }
        return students.get(students.size()-1).getStudentId()+1;
    }

    //todo: functie ce adauga un student in lista, primeste constructor ca parmetru
    public void add(Student student){
        this.students.add(student);
    }

    //todo: functie ce elimina un student, primeste constructor ca parametru
    public void remove(Student student){
        this.students.remove(student);
    }

    //todo

}
