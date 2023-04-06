package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Student;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ControlStudentTest {

    @Test
    public void testFindByFirstNameLastName(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        students.add(student);
        ControlStudent controlStudent = new ControlStudent(students);
        String expected=student.descriere();

        assertEquals(expected,controlStudent.findByFirstNameLastName(student.getFirstName(),
                student.getLastName()).descriere());
    }

    @Test
    public void testFindByFirstNameLastNameNull(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        students.add(student);
        ControlStudent controlStudent = new ControlStudent(students);
        String expected=null;

        assertEquals(expected, controlStudent.findByFirstNameLastName(student.getFirstName()+1,
                student.getLastName()+1));
    }
    
    @Test
    public void testNextId(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        students.add(student);
        ControlStudent controlStudent = new ControlStudent(students);
        int expected=students.size()+1;

        assertEquals(expected,controlStudent.nextId());
    }

    @Test
    public void testNextNull(){
        ArrayList<Student> students= new ArrayList<>();
        ControlStudent controlStudent= new ControlStudent(students);
        int expexted=-1;

        assertEquals(expexted,controlStudent.nextId());
    }

    @Test
    public void testAdd(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        ControlStudent controlStudent = new ControlStudent(students);
        controlStudent.add(student);
        String expected=student.descriere();

        assertEquals(expected,controlStudent.findByEmailPassword(student.getEmail(),student.getPassword()).descriere());
    }

    @Test
    public void testRemove(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        students.add(student);
        ControlStudent controlStudent = new ControlStudent(students);
        controlStudent.remove(student);
        String expected=null;

        assertEquals(expected,controlStudent.findByEmailPassword(student.getEmail(),student.getPassword()));
    }

    @Test
    public void testToSave(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        Student student1 = new Student("2,Alexandru,Pitesteanu,22,alexpit@gmail.com,alexp2000");
        students.add(student);
        students.add(student1);
        ControlStudent controlStudent = new ControlStudent(students);
        String expected=student.toSave()+"\n"+student1.toSave();

        assertEquals(expected,controlStudent.toSave());
    }

    @Test
    public void testToSaveNull(){
        ArrayList<Student> students = new ArrayList<>();
        ControlStudent controlStudent = new ControlStudent(students);
        String expected="";

        assertEquals(expected,controlStudent.toSave());
    }

    @Test
    public void testSave(){
        ArrayList<Student> students= new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,23,test@gmail.com,pass1234!");
        Student student1 = new Student("2,Alexandru,Pitesteanu,22,alexpit@gmail.com,alexp2000");
        students.add(student);
        students.add(student1);
        ControlStudent controlStudent = new ControlStudent(students);
        String path="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.student.txt";
        controlStudent.save(path);
        controlStudent.load(path);
        String expected=student.toSave()+"\n"+student1.toSave();

        assertEquals(expected,controlStudent.toSave());
    }

    @AfterEach
    private void clear(){
        ControlStudent controlStudent = new ControlStudent(new ArrayList<>());
        controlStudent.save("C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.student.txt");
    }
}
