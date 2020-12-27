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
public class DepRec {
    
    private int dID;
    private String dName;
    private int dMgrID;
    private int dLocID;

    public DepRec(int dID, String dName, int dMgrID, int dLocID) {
        this.dID = dID;
        this.dName = dName;
        this.dMgrID = dMgrID;
        this.dLocID = dLocID;
    }

    public DepRec() {
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getdMgrID() {
        return dMgrID;
    }

    public void setdMgrID(int dMgrID) {
        this.dMgrID = dMgrID;
    }

    public int getdLocID() {
        return dLocID;
    }

    public void setdLocID(int dLocID) {
        this.dLocID = dLocID;
    }

   
    
}
