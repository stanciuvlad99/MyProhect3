package ro.mycode.controllers;

import ro.mycode.models.Job;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlJob {
    private ArrayList<Job> jobs;
    private final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\job";

    public ControlJob(){
        this.jobs=new ArrayList<>();
        load();
    }

    public void load(){
        try {
            File file = new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Job job = new Job(text);
                this.jobs.add(job);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate joburile
    public void read(){
        for (int i=0; i<jobs.size(); i++){
            System.out.println(jobs.get(i).descriere());
        }
    }

    //todo: functie ce returneaza un job, primeste jobId ca prametru
    public Job findById(int jobId){
        for (int i=0; i<jobs.size(); i++){
            if (jobs.get(i).getJobId()==jobId){
                return jobs.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un job dupa nume, primeste nume ca parametru
    public Job findByName(String name){
        for (int i=0; i<jobs.size(); i++){
            if (jobs.get(i).getName().equals(name)){
                return jobs.get(i);
            }
        }
        return null;
    }

    //todo: functie ce adauga un job in lista, primeste constructor ca parametru
    public void add(Job job){
        this.jobs.add(job);
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (jobs.size()==0){
            return -1;
        }
        return jobs.get(jobs.size()-1).getJobId()+1;
    }

    //todo:functie ce elimina un job din baza de date, primeste constructor ca parametru
    public void remove(Job job){
        this.jobs.remove(job);
    }

    //todo: functie ce returneaza un job, primeste ca pramametru jobId
    public Job findByJobId(int jobId){
        for (int i=0; i<jobs.size(); i++){
            if (jobs.get(i).getJobId()==jobId){
                return jobs.get(i);
            }
        }
        return null;
    }

    //todo: functie ce face face update numelui unui job, primeste constructor ca parametru
    public void updateName(Job job){
        Job update= findByJobId(job.getJobId());
        if (job.getName().equals("")==false){
            update.setName(job.getName());
        }
    }

    //todo: functie ce face update id-ului si departamentului unui job, primeste constructor ca parametru
    public void updateIdDepartment(Job job){
        Job update=findByName(job.getName());
        if (job.getDepartment().equals("")==false){
            update.setDepartment(job.getDepartment());
        }
        if ((job.getJobId()==0)==false){
            update.setJobId(job.getJobId());
        }
    }

    //todo: functie ce returneaza toate joburile
    public String toSave(){
        int i=0;
        String text="";
        for (i=0; i<jobs.size()-1; i++){
            text+=jobs.get(i).toSave()+"\n";
        }
        text+=jobs.get(i).toSave();
        return text;
    }

    //todo: functie ce salveaza in fisier text job
    public void save(){
        try {
            File file = new File(FINAL_URL);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
