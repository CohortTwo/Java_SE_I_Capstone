/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

/**
 *
 * @author tthen
 */
public class Book {
    private int bno;
    private String stitle;
    private int custid;
    private String sauthor;
    

public Book(){
    
    
}

public Book(int bno,String stitle,int custid,String sauthor){
this.bno = bno;
this.stitle = stitle;
   this.custid=custid;
        this.sauthor=sauthor;
        }


 public int getbno() {
        return bno;
    }
 
    public void setbno(int bno) {
        this.bno = bno;
    }
    
    
    public int getcustid() {
        return custid;
    }
 
    public void setcustid(int custid) {
        this.custid = custid;
    }
    
    public String getstitle() {
        return stitle;
    }
 
    public void setstitle(String stitle) {
        this.stitle = stitle;
    }
    
    
    public String getsauthor() {
        return sauthor;
    }
 
    public void setsauthor(int bno) {
        this.sauthor = sauthor;
    }
    
}