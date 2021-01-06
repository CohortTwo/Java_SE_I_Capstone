/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.supplier;

import java.util.function.Supplier;
import Collections.supplier.SupplierObjClass;


/**
 *
 * @author sridh
 */
public class SupplierObjExample {
    	public static void main(String[] args) {
 
		Supplier studentSupplier = () -> new SupplierObjClass(1, "David", "M", 19);
                SupplierObjClass student = (SupplierObjClass) studentSupplier.get();
		System.out.println(student);
	}
}
