package ro.mycode.controllers;

import ro.mycode.models.Admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAdmin {
    private ArrayList<Admin> admins;
    private final String FINAL_PATH="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\admin";

    public ControlAdmin(){
        this.admins=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FINAL_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Admin admin = new Admin(text);
                this.admins.add(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        for (int i=0; i<admins.size(); i++){
            System.out.println(admins.get(i).descriere());
        }
    }
}
