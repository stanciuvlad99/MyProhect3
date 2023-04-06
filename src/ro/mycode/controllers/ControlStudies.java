package ro.mycode.controllers;

import ro.mycode.models.Studies;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlStudies {
    private ArrayList<Studies> studies;
    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\studies.txt";

    public ControlStudies(ArrayList<Studies> studies){
        this.studies=studies;
    }

    public ControlStudies(){
        this.studies=new ArrayList<>();
        load(FILE_PATH);
    }

    public void load(String path){
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            studies.clear();
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Studies studies = new Studies(text);
                this.studies.add(studies);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate studiile
    public void read(){
        for (int i=0; i<studies.size(); i++){
            System.out.println(studies.get(i).descriere());
        }
    }

    //todo: functie ce returneaza lista de studii, primeste studentId ca parametru
    public ArrayList<Studies> studiiPersonale(int studentId){
        ArrayList<Studies> list = new ArrayList<>();
        for (int i=0; i<studies.size(); i++){
            if (studies.get(i).getStudentId()==studentId){
                list.add(studies.get(i));
            }
        }
        return list;
    }

    //todo: funcie ce retueneaza studiile unui elev, primeste studiesId ca parametru
    public Studies findByStudiesId(int studiesId){
        for (int i=0; i<studies.size(); i++){
            if (studies.get(i).getStudiesId()==studiesId){
                return studies.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (studies.size()==0){
            return -1;
        }
        return studies.get(studies.size()-1).getStudiesId()+1;
    }

    //todo: functie ce adauga studii in lista, primeste constructor ca parametru
    public void add(Studies studies){
        this.studies.add(studies);
    }

    //todo: functie ce returneaza studii, primeste name si studentId ca paramtri
    public Studies findByNameStudentId(String name, int studentId){
        for (int i=0; i<studies.size(); i++){
            if (studies.get(i).getName().equals(name) && studies.get(i).getStudentId()==studentId){
                return studies.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina studii din lista, primeste constructor ca parametru
    public void remove(Studies studies){
        this.studies.remove(studies);
    }

    //todo: functie ce returneaza studii, primeste name ca parametru
    public Studies findByName(String name){
        for (int i=0; i<studies.size(); i++){
            if (studies.get(i).getName().equals(name)){
                return studies.get(i);
            }
        }
        return null;
    }

    //todo: functie ce face update studiilor, primeste constructor ca parametru
    public void update(Studies studies){
        Studies update=findByName(studies.getName());
        if (studies.getDepartment().equals("")==false){
            update.setDepartment(studies.getDepartment());
        }
        if ((studies.getYear()==0)==false){
            update.setYear(studies.getYear());
        }
    }

    //todo: functie ce returneaza toate studiile
    public String toSave(){
        if (studies.size()==0){
            return "";
        }
        int i=0;
        String text="";
        for (i=0; i<studies.size()-1; i++){
            text+=studies.get(i).toSave()+"\n";
        }
        text+=studies.get(i).toSave();
        return text;
    }

    //todo: functie ce salveaza in fiser text studies.txt
    public void save(String path) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
