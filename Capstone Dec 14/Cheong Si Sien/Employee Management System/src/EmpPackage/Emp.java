
package EmpPackage;

public class Emp {
    private String Name;
    private int EmpId;
    private String Email;
    private int DeptId;
    private double Salary;
    private double CommPct;
    private String Phone;

    public Emp(String Name, int EmpId, String Email, int DeptId, double Salary, double CommPct, String Phone) {
        this.Name = Name;
        this.EmpId = EmpId;
        this.Email = Email;
        this.DeptId = DeptId;
        this.Salary = Salary;
        this.CommPct = CommPct;
        this.Phone = Phone;
    }

    public Emp() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int EmpId) {
        this.EmpId = EmpId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getDeptId() {
        return DeptId;
    }

    public void setDeptId(int DeptId) {
        this.DeptId = DeptId;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public double getCommPct() {
        return CommPct;
    }

    public void setCommPct(double CommPct) {
        this.CommPct = CommPct;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Emp{" + "Name=" + Name + ", EmpId=" + EmpId + ", Email=" + Email + ", DeptId=" + DeptId + ", Salary=" + Salary + ", CommPct=" + CommPct + ", Phone=" + Phone + '}';
    }




}
