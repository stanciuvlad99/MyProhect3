package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Job;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlJobTest {

    @Test
    public void testFindById(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob = new ControlJob(jobs);
        String expected=job.descriere();

        assertEquals(expected,controlJob.findByJobId(job.getJobId()).descriere());
    }

    @Test
    public void testFindByIdNull(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob = new ControlJob(jobs);
        String expected=null;

        assertEquals(expected,controlJob.findByJobId(job.getJobId()+1));
    }

    @Test
    public void testFindByName(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob = new ControlJob(jobs);
        String expected=job.descriere();

        assertEquals(expected,controlJob.findByName(job.getName()).descriere());
    }

    @Test
    public void testFindByNameNull(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob = new ControlJob(jobs);
        String expected=null;

        assertEquals(expected,controlJob.findByName(job.getName()+1));
    }

    @Test
    public void testAdd(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        ControlJob controlJob = new ControlJob(jobs);
        controlJob.add(job);
        String expected=job.descriere();

        assertEquals(expected,controlJob.findByName(job.getName()).descriere());
    }

    @Test
    public void nextId(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        int expected=jobs.size()+1;
        ControlJob controlJob = new ControlJob(jobs);

        assertEquals(expected,controlJob.nextId());
    }

    @Test
    public void testNextIdNull(){
        ArrayList<Job> jobs = new ArrayList<>();
        ControlJob controlJob = new ControlJob(jobs);
        int expected=-1;

        assertEquals(expected,controlJob.nextId());
    }

    @Test
    public void testRemove(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob = new ControlJob(jobs);
        controlJob.remove(job);
        String expected=null;

        assertEquals(expected,controlJob.findByName(job.getName()));
    }

    @Test
    public void testUpdateName(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob = new ControlJob(jobs);
        Job job1 = new Job("1,Asistent medical,IT");
        controlJob.updateName(job1);
        String expected=job1.getName();

        assertEquals(expected,job.getName());
    }

    @Test
    public void testUpdateIdDepartment(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        jobs.add(job);
        ControlJob controlJob= new ControlJob(jobs);
        Job job1 = new Job("2,Inginer software,qwerty");
        controlJob.updateIdDepartment(job1);
        int expectedId=job1.getJobId();
        String expectedDepartment=job1.getDepartment();

        assertEquals(expectedId,job.getJobId());
        assertEquals(expectedDepartment,job.getDepartment());
    }

    @Test
    public void testToSave(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        Job job1 = new Job("2,Asistent medical,Medical");
        jobs.add(job);
        jobs.add(job1);
        ControlJob controlJob = new ControlJob(jobs);
        String expected=job.toSave()+"\n"+job1.toSave();

        assertEquals(expected,controlJob.toSave());
    }

    @Test
    public void testToSaveNull(){
        ArrayList <Job> jobs = new ArrayList<>();
        ControlJob controlJob = new ControlJob(jobs);
        String expected="";

        assertEquals(expected,controlJob.toSave());
    }

    @Test
    public void testSave(){
        ArrayList<Job> jobs = new ArrayList<>();
        Job job = new Job("1,Inginer software,IT");
        Job job1 = new Job("2,Asistent medical,Medical");
        jobs.add(job);
        jobs.add(job1);
        ControlJob controlJob = new ControlJob(jobs);
        String path="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.job.txt";
        controlJob.save(path);
        controlJob.load(path);
        String expected = job.toSave()+"\n"+job1.toSave();

        assertEquals(expected, controlJob.toSave());
    }

    @AfterEach
    private void clear(){
        ControlJob controlJob = new ControlJob(new ArrayList<>());
        controlJob.save("C:\\mycode\\OOP\\Incapsularea\\MyProject5\\test\\ro\\mycode\\data\\test.job.txt");
    }


}
