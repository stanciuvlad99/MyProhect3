package ro.mycode.models;

public class Apply {
    private int applyId=0;
    private int studentId=0;
    private int jobId=0;

    public Apply(String text){
        String []split=text.split(",");
        this.applyId=Integer.parseInt(split[0]);
        this.studentId=Integer.parseInt(split[1]);
        this.jobId=Integer.parseInt(split[2]);
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String descriere(){
        String descreire="Id-ul aplicarii este " + applyId + ", id-ul studentului este " + studentId +
                ", iar id-ul jobului este " + jobId;
        return descreire;
    }
}
