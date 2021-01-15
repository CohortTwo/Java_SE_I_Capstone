package EmpRecordFX;

import java.util.Date;

public class Employees {

    private int eid;
    private String fname;
    private String lname;
    private String job;
    private int deptid;
    private int mid;
    private String email;
    private int salary;
    private int comms;
    private Date hdate;

    public Employees(int eid, String fname, String lname, String job, int deptid, int mid, String email, int salary, int comms, Date hdate) {
        this.eid = eid;
        this.fname = fname;
        this.lname = lname;
        this.job = job;
        this.mid = mid;
        this.deptid = deptid;
        this.email = email;
        this.salary = salary;
        this.comms = comms;
        this.hdate = hdate;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getComms() {
        return comms;
    }

    public void setComms(int comms) {
        this.comms = comms;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }
}
