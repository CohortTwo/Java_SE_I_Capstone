/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

/**
 *
 * @author sridh
 */
class Org // Outer class defining the Organization
{

    String orgName = "Google";
    String locName = "Singapore";

    class HrDept // Inner class defining the department within the organization
    {

        String depHead = "James";
        int depCapacity = 100;
        String depLoc  = "KL";
    }

    class SalesDept // Inner class defining the department within the organization
    {

        String depHead = "David";
        int depCapacity = 10;
        String depLoc  = "SG";
    }

}

public class InnerReal {

    public static void main(String[] args) {
        Org company = new Org(); // Creating an Instance of the Org
        Org.HrDept hr = company.new HrDept(); // Creating an instance of the HR department
        Org.SalesDept sales = company.new SalesDept(); // Creating an instance of the sales department.

        System.out.print("At " + company.orgName + " " + company.locName + ", the Hr is headed by " + hr.depHead);
        System.out.print(", and " + " the Sales is headed by " + sales.depHead);

    }
}
