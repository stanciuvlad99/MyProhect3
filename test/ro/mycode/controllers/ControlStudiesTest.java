package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Studies;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlStudiesTest {

    @Test
    public void testStudiiPersonale(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        Studies studies2 = new Studies("2,1,Universitatea de Medicina si Farmacie,Medical,2023");
        Studies studies3 = new Studies("3,3,Facultatea de Drept,Juridic,2022");
        studies.add(studies1);
        studies.add(studies2);
        studies.add(studies3);
        ControlStudies controlStudies = new ControlStudies(studies);
        ArrayList<Studies> list = new ArrayList<>();
        for (int i=0; i<studies.size(); i++){
            list=controlStudies.studiiPersonale(1);
        }
        int expected=2;

        assertEquals(expected,list.size());
    }

    @Test
    public void testFindByStudiesId(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected=studies1.descriere();

        assertEquals(expected, controlStudies.findByStudiesId(studies1.getStudiesId()).descriere());
    }

    @Test
    public void testFindByStudiesIdNull(){
        ArrayList<Studies> studies= new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected=null;

        assertEquals(expected,controlStudies.findByStudiesId(studies1.getStudiesId()+1));
    }

    @Test
    public void testNextId(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        int expected=studies.size()+1;

        assertEquals(expected,controlStudies.nextId());
    }

    @Test
    public void testNextIdNull(){
        ArrayList<Studies> studies = new ArrayList<>();
        ControlStudies controlStudies = new ControlStudies(studies);
        int expected=-1;

        assertEquals(expected, controlStudies.nextId());
    }

    @Test
    public void testAdd(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        ControlStudies controlStudies = new ControlStudies(studies);
        controlStudies.add(studies1);
        String expected=studies1.descriere();

        assertEquals(expected, controlStudies.findByName(studies1.getName()).descriere());
    }

    @Test
    public void testFindByNameStudentId(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected=studies1.descriere();

        assertEquals(expected, controlStudies.findByNameStudentId(studies1.getName(),studies1.getStudentId()).descriere());
    }

    @Test
    public void testFindByNameStudentIdNull(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected=null;

        assertEquals(expected, controlStudies.findByNameStudentId(studies1.getName()+1,studies1.getStudentId()+1));
    }

    @Test
    public void testRemove(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        controlStudies.remove(studies1);
        String expected= null;

        assertEquals(expected,controlStudies.findByName(studies1.getName()));
    }

    @Test
    public void testFindByName(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected= studies1.descriere();

        assertEquals(expected,controlStudies.findByName(studies1.getName()).descriere());
    }

    @Test
    public void testFindByNameNull(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected=null;

        assertEquals(expected,controlStudies.findByName(studies1.getName()+1));
    }

    @Test
    public void testUpdate(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        studies.add(studies1);
        ControlStudies controlStudies = new ControlStudies(studies);
        Studies studies2 = new Studies("1,1,Universitatea Politehnica,qwerty,9999");
        controlStudies.update(studies2);
        String expectedDepartment=studies2.getDepartment();
        int expextedYear=studies2.getYear();

        assertEquals(expectedDepartment,studies1.getDepartment());
        assertEquals(expextedYear,studies1.getYear());
    }

    @Test
    public void testToSave(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        Studies studies2 = new Studies("2,2,Universitatea de Medicina si Farmacie,Medical,2023");
        studies.add(studies1);
        studies.add(studies2);
        ControlStudies controlStudies = new ControlStudies(studies);
        String expexted=studies1.toSave()+"\n"+studies2.toSave();

        assertEquals(expexted,controlStudies.toSave());
    }

    @Test
    public void testToSaveNull(){
        ArrayList <Studies> studies = new ArrayList<>();
        ControlStudies controlStudies = new ControlStudies(studies);
        String expected="";

        assertEquals(expected,controlStudies.toSave());
    }

    @Test
    public void testSave(){
        ArrayList<Studies> studies = new ArrayList<>();
        Studies studies1 = new Studies("1,1,Universitatea Politehnica,IT,2022");
        Studies studies2 = new Studies("2,2,Universitatea de Medicina si Farmacie,Medical,2023");
        studies.add(studies1);
        studies.add(studies2);
        ControlStudies controlStudies = new ControlStudies(studies);
        String path="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.studies.txt";
        controlStudies.save(path);
        controlStudies.load(path);
        String expected=studies1.toSave();
        String expected1=studies2.toSave();

        assertEquals(expected,controlStudies.findByName(studies1.getName()).toSave());
        assertEquals(expected1,controlStudies.findByName(studies2.getName()).toSave());
    }

    @AfterEach
    public void clear(){
        ControlStudies controlStudies = new ControlStudies(new ArrayList<>());
        controlStudies.save("C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.studies.txt");
    }

}
