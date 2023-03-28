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

    public void read(){
        for (int i=0; i<applies.size(); i++){
            System.out.println(applies.get(i).descriere());
        }
    }
}
