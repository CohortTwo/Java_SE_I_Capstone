/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.predicate.emppredicate;

/**
 *
 * @author blueg
 */
public class Employees {
    
    private Integer empId;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    public Employees(Integer empId, Integer age, String gender, String firstName, String lastName) {
        this.empId = empId;
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employees{" + "empId=" + empId + ", age=" + age + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
    
}
