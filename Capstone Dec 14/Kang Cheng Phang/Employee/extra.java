/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import static Employee.EmployeeMenu.Dept;
import static Employee.EmployeeMenu.DisplayHeader;
import static Employee.EmployeeMenu.Emp;
import static Employee.EmployeeMenu.menu;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class extra {

    private static final Pattern CHARS = Pattern.compile(".*");

    public static void queryDeptByName() {
        int i;
        if (!Dept.isEmpty()) {
            int j = 0;
            System.out.print("Please enter the name of the department: ");
            Scanner in = new Scanner(System.in);
            String DeptName = in.nextLine();
            for (i = 0; i < Dept.size(); i++) {
                if (Dept.get(i).getDeptName().contains(DeptName)) {
                    j++;
                    DisplayHeader();
                    System.out.println("Please refer below for information on "
                            + "\nDepartment id \t\t: \t" + Dept.get(i).getDeptID()
                            + "\nDepartment name \t: \t" + Dept.get(i).getDeptName()
                            + "\nDepartment manager id \t: \t" + Dept.get(i).getManagerID()
                            + "\nDepartment manager name\t: \t" + Dept.get(i).getManagerName());
                    break;
                }
                DisplayHeader();
                if (j == 0) {
                    System.out.println("Department does not exist!");
                } else {
                    System.out.println("This system has no information stored currently!");
                }
            }
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        DisplayHeader();
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void queryDeptById() {
        if (!Dept.isEmpty()) {
            int j = 0;
            System.out.print("Please enter department id: ");
            Scanner in = new Scanner(System.in);
            int DeptID = in.nextInt();
            for (int i = 0; i < Dept.size(); i++) {
                if (Dept.get(i).getDeptID() == DeptID) {
                    j++;
                    DisplayHeader();
                    System.out.println("Please refer below for information on "
                            + "\nDepartment id \t\t: \t" + Dept.get(i).getDeptID()
                            + "\nDepartment name \t: \t" + Dept.get(i).getDeptName()
                            + "\nDepartment manager id \t: \t" + Dept.get(i).getManagerID()
                            + "\nDepartment manager name\t: \t" + Dept.get(i).getManagerName());
                    break;
                } else {
                    System.out.println("This system has no information stored currently!");
                }
                DisplayHeader();
                if (j == 0) {
                    System.out.println("Department id does not exist!");
                }
            }
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        DisplayHeader();
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void queryEmpByName() {
        if (!Emp.isEmpty()) {
            int j = 0;
            System.out.print("Please enter the name of the employee: ");
            Scanner in = new Scanner(System.in);
            String EmpName = in.nextLine();
            for (int i = 0; i < Emp.size(); i++) {
                if (Emp.get(i).getEmpName().contains(EmpName)) {
                    j++;
                    DisplayHeader();
                    System.out.println("Please refer below for information on "
                            + "\nEmployee id \t\t: \t" + Emp.get(i).getEmpID()
                            + "\nEmployee's name \t: \t" + Emp.get(i).getEmpName()
                            + "\nEmployee's salary \t: \t" + Emp.get(i).getSalary()
                            + "\nEmployee's designation\t: \t" + Emp.get(i).getDesignation());
                    break;
                }
                DisplayHeader();
                if (j == 0) {
                    System.out.println("Employee does not exist!");
                } else {
                    System.out.println("This system has no information stored currently!");
                }
            }
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        DisplayHeader();
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void queryEmpById() {
        if (!Emp.isEmpty()) {
            int j = 0;
            System.out.print("Please enter employee id: ");
            Scanner in = new Scanner(System.in);
            int EmpID = in.nextInt();
            for (int i = 0; i < Emp.size(); i++) {
                if (Emp.get(i).getEmpID() == EmpID) {
                    j++;
                    DisplayHeader();
                    System.out.println("Please refer below for information on "
                            + "\nEmployee id \t\t: \t" + Emp.get(i).getEmpID()
                            + "\nEmployee'sname \t\t: \t" + Emp.get(i).getEmpName()
                            + "\nEmployee's salary id \t: \t" + Emp.get(i).getSalary()
                            + "\nEmployee's designation\t: \t" + Emp.get(i).getDesignation());
                    break;
                } else {
                    System.out.println("This system has no information stored currently!");
                }
                DisplayHeader();
                if (j == 0) {
                    System.out.println("Department id does not exist!");
                }
            }
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        DisplayHeader();
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void addDept() {
        int deptID;
        String deptName;
        int managerID;
        String managerName;
        Scanner in = new Scanner(System.in);
        {
            try {
                System.out.println("Please enter the department id number: ");
                deptID = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the department name: ");
                deptName = in.nextLine();
                System.out.println("Please enter the manager id: ");
                managerID = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the manager name: ");
                managerName = in.nextLine();
                Dept.add(new EmployeeClass(deptID, deptName, managerID, managerName));
                DisplayHeader();
                System.out.println("New entry to department list added!");
            } catch (InputMismatchException im) {
                DisplayHeader();
                System.out.println("Input value does not match the expected data type!");
                System.out.println("Please enter input again.");
                DisplayHeader();
            } finally {
                DisplayHeader();
                menu();
            }
        }
    }

    public static void addEmp() {
        int empID;
        String empName;
        float salary;
        String designation;
        Scanner in = new Scanner(System.in);
        {
            try {
                System.out.println("Please enter the employee id number: ");
                empID = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the employee's name: ");
                empName = in.nextLine();
                System.out.println("Please enter the employee's salary: ");
                salary = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the employee's designation: ");
                designation = in.nextLine();
                Emp.add(new EmployeeClass().new Employees(empID, empName, salary, designation));
                DisplayHeader();
                System.out.println("New entry to employee list added!");
            } catch (InputMismatchException im) {
                DisplayHeader();
                System.out.println("Input value does not match the expected data type!");
                System.out.println("Please enter input again.");
                DisplayHeader();
            } finally {
                DisplayHeader();
                menu();
            }
        }
    }

    public static void modifyDeptById() {
        if (!Dept.isEmpty()) {
            DisplayHeader();
            System.out.println("Please enter department id for the entry you want to amend: ");
            DisplayHeader();
            Scanner in = new Scanner(System.in);
            int DeptId = in.nextInt();
            for (int i = 0; i < Dept.size(); i++) {
                if (Dept.get(i).getDeptID() == DeptId) {
                    DisplayHeader();
                    System.out.println("1. Department id\n2. Department name \n3. Manager id\n4. Manager name");
                    try {
                        DisplayHeader();
                        switch (in.nextInt()) {
                            case 1:
                                System.out.println("Please enter new department id: ");
                                int newDeptId = in.nextInt();
                                String deptName = Dept.get(i).getDeptName();
                                int managerID = Dept.get(i).getManagerID();
                                String managerName = Dept.get(i).getManagerName();
                                Dept.set(i, new EmployeeClass(newDeptId, deptName, managerID, managerName));
                                DisplayHeader();
                                System.out.println("Department id updated successfully!");
                                break;
                            case 2:
                                System.out.println("Please enter new department name: ");
                                DeptId = Dept.get(i).getDeptID();
                                in.nextLine();
                                String newdeptName = in.nextLine();
                                managerID = Dept.get(i).getManagerID();
                                managerName = Dept.get(i).getManagerName();
                                Dept.set(i, new EmployeeClass(DeptId, newdeptName, managerID, managerName));
                                DisplayHeader();
                                System.out.println("Department name updated successfully!");
                                break;
                            case 3:
                                System.out.println("Please enter new manager id: ");
                                DeptId = Dept.get(i).getDeptID();
                                deptName = Dept.get(i).getDeptName();
                                int newmanagerID = in.nextInt();
                                managerName = Dept.get(i).getManagerName();
                                Dept.set(i, new EmployeeClass(DeptId, deptName, newmanagerID, managerName));
                                DisplayHeader();
                                System.out.println("Manager id updated successfully!");
                                break;
                            case 4:
                                System.out.println("Please enter new manager name: ");
                                DeptId = Dept.get(i).getDeptID();
                                deptName = Dept.get(i).getDeptName();
                                managerID = Dept.get(i).getManagerID();
                                in.nextLine();
                                String newmanagerName = in.nextLine();
                                Dept.set(i, new EmployeeClass(DeptId, deptName, managerID, newmanagerName));
                                DisplayHeader();
                                System.out.println("Manager name updated successfully!");
                                break;
                            default:
                                System.exit(0);//exit program
                                break;
                        }
                    } catch (InputMismatchException im) {
                        menu();
                        System.out.print("Please enter the corresponding numeric value to navigate:");
                        DisplayHeader();
                    }
                } else {
                    DisplayHeader();
                    System.out.println("This system has no information stored currently!");
                }
            }
            DisplayHeader();
            System.out.println("Enter any key to return to main menu.");
            DisplayHeader();
            if (in.hasNext(CHARS) == true) {
                menu();
            }
        }
    }

    public static void modifyEmpById() {
        if (!Emp.isEmpty()) {
            DisplayHeader();
            System.out.println("Please enter employee id: ");
            DisplayHeader();
            Scanner in = new Scanner(System.in);
            int EmpId = in.nextInt();
            for (int i = 0; i < Emp.size(); i++) {
                if (Emp.get(i).getEmpID() == EmpId) {
                    System.out.println("1. Employee id\n2. Employee name \n3. Salary\n4. Designation");
                    try {
                        DisplayHeader();
                        switch (in.nextInt()) {
                            case 1:
                                System.out.println("Please enter new employee id: ");
                                int newEmpId = in.nextInt();
                                String EmpName = Emp.get(i).getEmpName();
                                double salary = Emp.get(i).getSalary();
                                String designation = Emp.get(i).getDesignation();
                                Emp.set(i, new EmployeeClass().new Employees(newEmpId, EmpName, (float) salary, designation));
                                DisplayHeader();
                                System.out.println("Department id updated successfully!");
                                break;
                            case 2:
                                System.out.println("Please enter new employee id: ");
                                EmpId = Emp.get(i).getEmpID();
                                in.nextLine();
                                String newEmpName = in.nextLine();
                                salary = Emp.get(i).getSalary();
                                designation = Emp.get(i).getDesignation();
                                Emp.set(i, new EmployeeClass().new Employees(EmpId, newEmpName, (float) salary, designation));
                                DisplayHeader();
                                System.out.println("Department id updated successfully!");
                                break;
                            case 3:
                                System.out.println("Please enter new employee id: ");
                                EmpId = Emp.get(i).getEmpID();
                                EmpName = Emp.get(i).getEmpName();
                                double newsalary = in.nextInt();
                                designation = Emp.get(i).getDesignation();
                                Emp.set(i, new EmployeeClass().new Employees(EmpId, EmpName, (float) newsalary, designation));
                                DisplayHeader();
                                System.out.println("Department id updated successfully!");
                                break;
                            case 4:
                                System.out.println("Please enter new employee id: ");
                                EmpId = Emp.get(i).getEmpID();
                                EmpName = Emp.get(i).getEmpName();
                                salary = Emp.get(i).getSalary();
                                in.nextLine();
                                String newdesignation = in.nextLine();
                                Emp.set(i, new EmployeeClass().new Employees(EmpId, EmpName, (float) salary, newdesignation));
                                DisplayHeader();
                                System.out.println("Department id updated successfully!");
                                break;
                            default:
                                System.exit(0);//exit program
                                break;
                        }
                    } catch (InputMismatchException im) {
                        menu();
                        System.out.print("Please enter the corresponding numeric value to navigate:");
                        DisplayHeader();
                    }
                } else {
                    DisplayHeader();
                    System.out.println("This system has no information stored currently!");
                }
            }
            DisplayHeader();
            System.out.println("Enter any key to return to main menu.");
            DisplayHeader();
            if (in.hasNext(CHARS) == true) {
                menu();
            }
        }
    }

    public static void delDeptById() {
        if (!Dept.isEmpty()) {
            int j = 0;
            DisplayHeader();
            System.out.println("Please enter department id: ");
            Scanner in = new Scanner(System.in);
            int DeptId = in.nextInt();
            for (int i = 0; i < Dept.size(); i++) {
                if (Dept.get(i).getDeptID() == DeptId) {
                    j++;
                    int delDeptId = Dept.get(i).getDeptID();
                    String delDeptName = Dept.get(i).getDeptName();
                    Dept.remove(i);
                    System.out.println("Department id " + delDeptId + ", department " + delDeptName + " has been deleted from the system successfully!");
                    break;
                } else {
                    DisplayHeader();
                    System.out.println("This system has no information stored currently!");
                }
                if (j == 0) {
                    DisplayHeader();
                    System.out.println("Department id does not exist!");
                }
            }
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        DisplayHeader();
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void delEmpById() {
        if (!Emp.isEmpty()) {
            int j = 0;
            DisplayHeader();
            System.out.println("Please enter employee id: ");
            Scanner in = new Scanner(System.in);
            int DeptId = in.nextInt();
            for (int i = 0; i < Emp.size(); i++) {
                if (Emp.get(i).getEmpID() == DeptId) {
                    j++;
                    int delEmpId = Emp.get(i).getEmpID();
                    String delEmpName = Emp.get(i).getEmpName();
                    Emp.remove(i);
                    System.out.println("Employee id " + delEmpId + ", employee " + delEmpName + " has been deleted from the system successfully!");
                    break;
                } else {
                    DisplayHeader();
                    System.out.println("This system has no information stored currently!");
                }
                if (j == 0) {
                    DisplayHeader();
                    System.out.println("Employee id does not exist!");
                }
            }
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        DisplayHeader();
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void queryAll() {
        if (!Emp.isEmpty()) {
            for (int i = 0; i < Emp.size(); i++) {
                DisplayHeader();
                System.out.println("The company information for "
                        + "\nEmployee id \t\t: \t" + Emp.get(i).getEmpID()
                        + "\nEmployee name \t\t: \t" + Emp.get(i).getEmpName()
                        + "\nEmployee's salary \t: \t" + Emp.get(i).getSalary()
                        + "\nEmployee's designation\t: \t" + Emp.get(i).getDesignation()
                        + "\nDepartment id\t\t: \t" + Dept.get(i).getDeptID()
                        + "\nDepartment name\t\t: \t" + Dept.get(i).getDeptName()
                        + "\nManager id\t\t: \t" + Dept.get(i).getManagerID()
                        + "\nManager name\t\t: \t" + Dept.get(i).getManagerName());
                DisplayHeader();
            }
        } else {
            DisplayHeader();
            System.out.println("This system has no information stored currently!");
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }
}
