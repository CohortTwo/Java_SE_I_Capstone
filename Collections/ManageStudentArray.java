/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sridh
 */
public class ManageStudentArray {

    static ArrayList<Student> arr = new ArrayList<Student>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("--------------Student Course Management System-----------");
        System.out.println("1.Query all student information\n2. Query according to student number\n3. Add student\n4. Modify student information\n5. Delete student\n6. Exit");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                findAll();
                break;
            case 2:
                findId();
                break;
            case 3:
                add();
                break;
            case 4:
                change();
                break;
            case 5:
                delete();
                break;

        }
    }

    public static void findAll() {
        if (arr.size() != 0) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("The student information for student number:" + arr.get(i).getId() + " is: \n------------------ --\n"
                        + "Name:" + arr.get(i).getName() + "\n age is:" + arr.get(i).getAge() + "\n gender is:"
                        + arr.get(i).getGender() + "\n--------------------\n\n");
            }
        } else {
            System.out.println("This system has no student information temporarily!");

        }
        menu();

    }

    public static void findId() {
        int i;
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter student id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    j++;
                    System.out.println("The student information for student number:" + arr.get(i).getId() + " is: \n------------------ --\n"
                            + "Name:" + arr.get(i).getName() + "\n age is:" + arr.get(i).getAge() + "\n gender is:"
                            + arr.get(i).getGender() + "\n--------------------\n\n");

                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system temporarily has no such id student information!");
            }
        } else {
            System.out.println("This system has no student information temporarily!");
        }
        menu();

    }

    public static void add() {
        int id;
        String name;
        int age;
        String gender;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the student id (integer):");
        id = sc.nextInt();
        System.out.println("Please enter the student name:");
        name = sc.next();
        System.out.println("Please enter the student age (integer):");
        age = sc.nextInt();
        System.out.println("Please enter student gender:");
        gender = sc.next();
        arr.add(new Student(id, name, age, gender));
        menu();
    }

    public static void change() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter student id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    String name;
                    int age;
                    String gender;
                    System.out.println("Please enter the modified student name:");
                    name = sc.next();
                    System.out.println("Please enter the modified student age:");
                    age = sc.nextInt();
                    System.out.println("Please enter the modified student gender:");
                    gender = sc.next();
                    arr.set(i, new Student(id, name, age, gender));
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such id student information!");
            }
        } else {
            System.out.println("This system has no student information temporarily!");
        }
        menu();
    }

    public static void delete() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter student id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    int oid = arr.get(i).getId();
                    arr.remove(i);
                    System.out.println("Student ID:" + oid + "The student information has been deleted successfully!");
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has no such id student information!");
            }
        } else {
            System.out.println("This system has no student information temporarily!");
        }
        menu();
    }

}
