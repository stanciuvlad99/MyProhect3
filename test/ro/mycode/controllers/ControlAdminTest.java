package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Admin;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlAdminTest {

    @Test
    public void testFindByEmailPassword() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        admins.add(admin);
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String expected = admin.descriere();

        assertEquals(expected, controlAdmin.findByEmailPassword(admin.getEmail(), admin.getPassword()).descriere());
    }

    @Test
    public void testToSave() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        Admin admin1 = new Admin("2,mirelparaschiv@hotmail.com,m1r3lp4r45ch1v,Mirel,Paraschiv");
        admins.add(admin);
        admins.add(admin1);
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String expected=admin.toSave()+"\n"+admin1.toSave();

        assertEquals(expected,controlAdmin.toSave());
    }

    @Test
    public void testToSaveNull(){
        ArrayList<Admin> admins = new ArrayList<>();
        ControlAdmin controlAdmin= new ControlAdmin(admins);
        String expected="";

        assertEquals(expected,controlAdmin.toSave());
    }

    @Test
    public void testSave(){
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        Admin admin1 = new Admin("2,mirelparaschiv@hotmail.com,m1r3lp4r45ch1v,Mirel,Paraschiv");
        admins.add(admin);
        admins.add(admin1);
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String path="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.admin.txt";
        controlAdmin.save(path);
        controlAdmin.load(path);
        String expected=admin.toSave()+"\n"+admin1.toSave();

        assertEquals(expected,controlAdmin.toSave());
    }

    @Test
    public void add(){
        ArrayList <Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        controlAdmin.add(admin);
        String expected=admin.descriere();

        assertEquals(expected,controlAdmin.findByEmailPassword(admin.getEmail(), admin.getPassword()).descriere());
    }

    @AfterEach
    private void clear(){
        ControlAdmin controlAdmin = new ControlAdmin(new ArrayList<>());
        controlAdmin.save("C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.admin.txt");
    }

}
