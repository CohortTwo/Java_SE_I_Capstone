/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author chiangyong
 */
public class Employee {
    
    String name;
    Integer age;
    String email;
    Integer empID;
    Gender gender;
    Float salary;
    String hire_date;
    String job_ID;
    String Dept;
    

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, Integer age, String email, Integer empID, Gender gender, Float salary, String hire_date, String job_ID, String Dept) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.empID = empID;
        this.gender = gender;
        this.salary = salary;
        this.hire_date = hire_date;
        this.job_ID = job_ID;
        this.Dept = Dept;
    }
    
    public Employee(String name, Integer age, String email, Integer empID, Gender gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.empID = empID;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getJob_ID() {
        return job_ID;
    }

    public void setJob_ID(String job_ID) {
        this.job_ID = job_ID;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String Dept) {
        this.Dept = Dept;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", age=" + age + ", email=" + email + ", empID=" + empID + ", gender=" + gender + ", salary=" + salary + ", hire_date=" + hire_date + ", job_ID=" + job_ID + ", Dept=" + Dept + '}';
    }

}
