/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

/**
 *
 * @author sridhar
 */
 class Parent{
	
	public void home(){
		System.out.println("Parent's home");
	}
	public void car(){
		System.out.println("Parent's Car");
	}	
}
class Child extends Parent{
	
	@Override
	public void car() {
		System.out.println("Child's Car");		
	}	
}
public class TestOverriding {

	public static void main(String[] args) {
		
		Child c = new Child();
		c.home();
		c.car();
	}

}