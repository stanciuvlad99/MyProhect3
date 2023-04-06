package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Apply;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlApplyTest {

    @Test
    public void testAplicariPersonale() {
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        Apply apply1 = new Apply("2,2,2");
        Apply apply2 = new Apply("3,2,3");
        Apply apply3 = new Apply("4,2,4");
        applies.add(apply);
        applies.add(apply1);
        applies.add(apply2);
        applies.add(apply3);
        ControlApply controlApply = new ControlApply(applies);
        ArrayList<Apply> list = null;
        for (int i = 0; i < applies.size(); i++) {
            list = controlApply.aplcariPersonale(2);
        }
        int expected = 3;

        assertEquals(expected, list.size());
    }

    @Test
    public void testFindByStudentIdJobId(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        applies.add(apply);
        ControlApply controlApply = new ControlApply(applies);
        String expected= apply.descriere();

        assertEquals(expected,controlApply.findByStudentIdJobId(apply.getJobId(), apply.getStudentId()).descriere());
    }

    @Test
    public void testFindByStudentIdJobIdNull(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        applies.add(apply);
        ControlApply controlApply = new ControlApply(applies);
        String expected=null;

        assertEquals(expected,controlApply.findByStudentIdJobId(apply.getStudentId()+1,
                apply.getJobId()+1));
    }

    @Test
    public void testNextId(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        applies.add(apply);
        ControlApply controlApply = new ControlApply(applies);
        int expected=applies.size()+1;

        assertEquals(expected,controlApply.nextId());
    }

    @Test
    public void testNextIdNull(){
        ArrayList<Apply> applies = new ArrayList<>();
        ControlApply controlApply = new ControlApply(applies);
        int expected=-1;

        assertEquals(expected,controlApply.nextId());
    }

    @Test
    public void testAdd(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        ControlApply controlApply = new ControlApply(applies);
        controlApply.add(apply);
        String expected= apply.descriere();

        assertEquals(expected,controlApply.findByStudentIdJobId(apply.getStudentId(), apply.getJobId()).descriere());
    }

    @Test
    public void testRemove(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        applies.add(apply);
        ControlApply controlApply = new ControlApply(applies);
        controlApply.remove(apply);
        String expected=null;

        assertEquals(expected,controlApply.findByStudentIdJobId(apply.getStudentId(), apply.getJobId()));
    }

    @Test
    public void testFrecventa(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,2,1");
        Apply apply1 = new Apply("2,4,2");
        Apply apply2 = new Apply("3,4,3");
        Apply apply3 = new Apply("4,4,4");
        applies.add(apply);
        applies.add(apply1);
        applies.add(apply2);
        applies.add(apply3);
        ControlApply controlApply = new ControlApply(applies);
        int []frecventa=controlApply.frecventa();
        int actual = frecventa[4];
        int expected=3;

        assertEquals(expected,actual);
    }

    @Test
    public void testPozitieMaximaJob(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,3,1");
        Apply apply1 = new Apply("2,3,2");
        Apply apply2 = new Apply("3,3,3");
        Apply apply3 = new Apply("4,3,4");
        applies.add(apply);
        applies.add(apply1);
        applies.add(apply2);
        applies.add(apply3);
        ControlApply controlApply = new ControlApply(applies);
        int expected=3;

        assertEquals(expected,controlApply.pozitieMaximaJob(controlApply.frecventa()));
    }

    @Test
    public void testIdJobFrecventat(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,3,1");
        Apply apply1 = new Apply("2,1,2");
        Apply apply2 = new Apply("3,1,3");
        Apply apply3 = new Apply("4,1,4");
        applies.add(apply);
        applies.add(apply1);
        applies.add(apply2);
        applies.add(apply3);
        ControlApply controlApply = new ControlApply(applies);
        int expected=1;

        assertEquals(expected,controlApply.idJobFrecventat());
    }

    @Test
    public void testToSave(){
        ArrayList <Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        Apply apply1 = new Apply("2,2,2");
        applies.add(apply);
        applies.add(apply1);
        ControlApply controlApply = new ControlApply(applies);
        String expected = apply.toSave()+"\n"+apply1.toSave();

        assertEquals(expected,controlApply.toSave());
    }

    @Test
    public void testToSaveNull(){
        ArrayList<Apply> applies = new ArrayList<>();
        ControlApply controlApply = new ControlApply(applies);
        String expected="";

        assertEquals(expected,controlApply.toSave());
    }

    @Test
    public void testSave(){
        ArrayList<Apply> applies = new ArrayList<>();
        Apply apply = new Apply("1,1,1");
        Apply apply1 = new Apply("2,2,2");
        applies.add(apply);
        applies.add(apply1);
        ControlApply controlApply = new ControlApply(applies);
        String path="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.apply.txt";
        controlApply.save(path);
        controlApply.load(path);
        String expected=apply.toSave()+"\n"+apply1.toSave();

        assertEquals(expected, controlApply.toSave());
    }

    @AfterEach
    private void clear(){
        ControlApply controlApply = new ControlApply(new ArrayList<>());
        controlApply.save("C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.apply.txt");
    }

}
