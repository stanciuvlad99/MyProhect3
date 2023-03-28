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

    public void read(){
        for (int i=0; i<jobs.size(); i++){
            System.out.println(jobs.get(i).descriere());
        }
    }
}
