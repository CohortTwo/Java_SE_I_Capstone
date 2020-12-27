/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcl;

/**
 *
 * @author chiangyong
 */
public class EmpRecord {
    
    private int eID;
    private String efirstName;
    private String elastName;
    private String eEmail;
    private String ePhone;
    private String eHireDate;
    private String eJobID;
    private float eSalary;
    private float eCommPct;
    private int eMgrID;
    private int eDepID;

    public EmpRecord(int eID, String efirstName, String elastName, String eEmail, String ePhone, String eHireDate, String eJobID, float eSalary, float eCommPct, int eMgrID, int eDepID) {
        this.eID = eID;
        this.efirstName = efirstName;
        this.elastName = elastName;
        this.eEmail = eEmail;
        this.ePhone = ePhone;
        this.eHireDate = eHireDate;
        this.eJobID = eJobID;
        this.eSalary = eSalary;
        this.eCommPct = eCommPct;
        this.eMgrID = eMgrID;
        this.eDepID = eDepID;
    }

    public EmpRecord() {
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getEfirstName() {
        return efirstName;
    }

    public void setEfirstName(String efirstName) {
        this.efirstName = efirstName;
    }

    public String getElastName() {
        return elastName;
    }

    public void setElastName(String elastName) {
        this.elastName = elastName;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public String geteHireDate() {
        return eHireDate;
    }

    public void seteHireDate(String eHireDate) {
        this.eHireDate = eHireDate;
    }

    public String geteJobID() {
        return eJobID;
    }

    public void seteJobID(String eJobID) {
        this.eJobID = eJobID;
    }

    public float geteSalary() {
        return eSalary;
    }

    public void seteSalary(float eSalary) {
        this.eSalary = eSalary;
    }

    public float geteCommPct() {
        return eCommPct;
    }

    public void seteCommPct(float eCommPct) {
        this.eCommPct = eCommPct;
    }

    public int geteMgrID() {
        return eMgrID;
    }

    public void seteMgrID(int eMgrID) {
        this.eMgrID = eMgrID;
    }

    public int geteDepID() {
        return eDepID;
    }

    public void seteDepID(int eDepID) {
        this.eDepID = eDepID;
    }

 


    
    
}


