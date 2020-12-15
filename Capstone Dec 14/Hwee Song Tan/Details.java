/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */

package Lsystem;

public class Details {
    
   private int bk_id;
   private String bk_title;
   private int Cust_id;
   private String author;
 
public Details(){
}   

    public Details(int bk_id, String bk_title, int Cust_id, String author) {
        this.bk_id = bk_id;
        this.bk_title = bk_title;
        this.Cust_id = Cust_id;
        this.author = author;
    }

    public int getBk_id() {
        return bk_id;
    }

    public void setBk_id(int bk_id) {
        this.bk_id = bk_id;
    }

    public String getBk_title() {
        return bk_title;
    }

    public void setBk_title(String bk_title) {
        this.bk_title = bk_title;
    }

    public int getCust_id() {
        return Cust_id;
    }

    public void setCust_id(int Cust_id) {
        this.Cust_id = Cust_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
   

}



