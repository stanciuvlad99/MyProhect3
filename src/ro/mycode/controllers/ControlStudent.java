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



}
