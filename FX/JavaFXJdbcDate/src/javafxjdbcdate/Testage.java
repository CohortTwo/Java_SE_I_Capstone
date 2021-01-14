/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxjdbcdate;
import java.util.Date;


/**
 *
 * @author sridh
 */
public class Testage {
    private String name;
    private Date dob;
    
    public Testage(String name, Date dob){
        this.name = name;
        this.dob = dob;
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

   
}
