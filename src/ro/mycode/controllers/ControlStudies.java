package ro.mycode.controllers;

import ro.mycode.models.Studies;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlStudies {
    private ArrayList<Studies> studies;
    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\studies";

    public ControlStudies(){
        this.studies=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Studies studies = new Studies(text);
                this.studies.add(studies);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        for (int i=0; i<studies.size(); i++){
            System.out.println(studies.get(i).descriere());
        }
    }
}
