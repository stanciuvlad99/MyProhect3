package ro.mycode.controllers;

import ro.mycode.models.Apply;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlApply {
    private ArrayList<Apply> applies;
    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\apply";

    public ControlApply(){
        this.applies= new ArrayList<>();
        laod();
    }

    private void laod() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Apply apply = new Apply(text);
                this.applies.add(apply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza totate aplicarile
    public void read(){
        for (int i=0; i<applies.size(); i++){
            System.out.println(applies.get(i).descriere());
        }
    }

    //todo: functie ce returneaza toate aplicarile, primeste studnet id ca parametru
    public ArrayList<Apply> aplcariPersonale(int studentId){
        ArrayList<Apply> list = new ArrayList<>();
        for (int i=0; i<applies.size(); i++){
            if (applies.get(i).getStudentId()==studentId){
                list.add(applies.get(i));
            }
        }
        return list;
    }

    //todo: functie ce returneaza aplicacare, primeste studentId si jobId ca parametri
    public Apply findByStudentIdJobId(int studentId, int jobId){
        for (int i=0; i<applies.size(); i++){
            if (applies.get(i).getStudentId()==studentId && applies.get(i).getJobId()==jobId){
                return applies.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (applies.size()==0){
            return -1;
        }
        return applies.get(applies.size()-1).getApplyId()+1;
    }

    //todo: functie ce adauga o aplicare in lista, primeste constructor ca parametru
    public void add(Apply apply){
        this.applies.add(apply);
    }

    //todo: functie ce elimina un aplicare, primeste constructor ca parametru
    public void remove(Apply apply){
        this.applies.remove(apply);
    }

    //todo: functie ce returneza frecventa
    public int[] frecventa(){
        int frecventa[]=new int[10000];
        for (int i=0; i<applies.size(); i++){
            frecventa[applies.get(i).getStudentId()]++;
        }
        return frecventa;
    }

    //todo: functie ce returneaza pozitia jobului cel mai frecventat, primeste vector ca parametru
    public int pozitieMaximaJob(int vector[]) {
        int max=vector[0];
        int pozitie=0;

        for (int i=0; i<vector.length; i++){
            if (max<vector[i]){
                max=vector[i];
                pozitie=i;
            }
        }
        return pozitie;
    }

    //todo: functie ce returneaza id-ul celui mai frecventat job
    public int idJobFrecventat(){
        return pozitieMaximaJob(frecventa());
    }


}
