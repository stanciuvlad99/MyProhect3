package ro.mycode.controllers;

import ro.mycode.models.Job;

import java.io.File;
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



}
