package Lsystem;

/**
 *
 * @author andrew
 */


import java.util.ArrayList;
import java.util.Scanner;

public class StuMgtSys {
    
static ArrayList<Details>ar1 = new ArrayList<Details>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Details(int bk_id, String bk_title, int Cust_id, String author)
    ar1.add(new Details(999,"To kill a mocking bird",900,"Able Brown"));
    ar1.add(new Details(998,"Macbeth",899,"Charlie Denmark"));
    ar1.add(new Details(997,"The tale of 2 cities",897,"Evans Frank"));

        lib_menu();

    }
   
    public static void lib_menu() {
        System.out.println("---------Library Enquiry System--------");
        System.out.println("1. Query all books \n2. Query by book ID \n3. Add book \n4. Modify information\n5. Delete by book id\n6. Exit");
        Scanner inp = new Scanner(System.in);
        try
        {
            switch (inp.nextInt()) 
            {
            case 1:
                All_Bk();
                break;
            case 2:
                Bkby_id();
                break;
            case 3:
                add_bk();
                break;
            case 4:
                mod_bk();
                break;
            case 5:
                del_bk();
                break;
            case 6:
                System.exit(0);//End program
                break;

            }
        } catch (java.util.InputMismatchException e){
            System.out.println(e+"\n"+"Input a number <1 to 6>\n");
        }
        lib_menu();
    }
  
    public static void All_Bk(){
        if (ar1.size() !=0) {
            for (int i = 0; i < ar1.size(); i++) {
                System.out.println("The Library Information System" + 
                        " \n--------------------------------\n"+
                        " Book ID:" + ar1.get(i).getBk_id() +"\n"
                        + " Book Title:" + ar1.get(i).getBk_title() + 
                        "\n Author:" + ar1.get(i).getAuthor() + 
                        "\n Customer ID:" +ar1.get(i).getCust_id()+ 
                        "\n--------------------------------\n\n" );
            }
        } else {
            System.out.println("This system has no information temporarily!\n");

        }
        lib_menu();
    }
            
    public static void Bkby_id(){
        int i;
        if (ar1.size() != 0) {
            int j = 0;
            System.out.println("Please enter book ID!");
            Scanner inp = new Scanner(System.in);
            try
            {
            int bk_id = inp.nextInt();
            
            for (i = 0; i < ar1.size(); i++) {
                if (ar1.get(i).getBk_id() == bk_id) {
                    j++;
                    System.out.println("The Library Information System" + 
                        " \n--------------------------------\n"+
                        " Book ID: " + ar1.get(i).getBk_id() +"\n"
                        + " Book Title: " + ar1.get(i).getBk_title() + 
                        "\n Author: " + ar1.get(i).getAuthor() + 
                        "\n Customer ID: " +ar1.get(i).getCust_id()+ 
                        "\n--------------------------------\n\n" );
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no book with this ID!\n");
            }
            //if -else statement end
            } catch (java.util.InputMismatchException e)
            {
                System.out.println(e+"\n Input a 3-digit book ID\n");
            }
        } else {
            System.out.println("This system has no book information temporarily!\n");
        }
        lib_menu();

    }  
    
    public static void add_bk(){
        int bk_id;
        String bk_title;
        String author;
        int cust_id;
        
        Scanner inp = new Scanner(System.in);
        
        System.out.println("Please enter the Book id (integer):");
        try{   
        bk_id = Integer.parseInt(inp.nextLine());
        
        System.out.println("Please enter the Book Title:");
        bk_title = inp.nextLine();
        System.out.println("Please enter Author:");
        author = inp.nextLine();
        System.out.println("Please enter the customer ID (integer):");
        
        cust_id = Integer.parseInt(inp.nextLine());
        
        
        ar1.add(new Details(bk_id,bk_title,cust_id,author));
        } catch (java.lang.NumberFormatException e)
                {
                    System.out.println(e+"\n 3-digit ID expected for ID\n");
                }
        lib_menu();
    }
    
    public static void mod_bk() {
        if (ar1.size() != 0) {
            int j = 0;
            System.out.println("Please enter book ID!");
            Scanner inp = new Scanner(System.in);
            try {
                int bk_id = Integer.parseInt(inp.nextLine());

                for (int i = 0; i < ar1.size(); i++) {
                    if (ar1.get(i).getBk_id() == bk_id) {
                        String bk_title;
                        int cust_id;
                        String author;
                        System.out.println("Please enter the modified Book Title:");
                        bk_title = inp.nextLine();
                        System.out.println("Please enter the modified Author:");
                        author = inp.nextLine();
                        System.out.println("Please enter the modified customer ID (integer):");
                        cust_id = Integer.parseInt(inp.nextLine());
                        ar1.set(i, new Details(bk_id, bk_title, cust_id, author));

                        j++;
                        break;
                    }
                }
                if (j == 0) {
                    System.out.println("This system has no such book ID!\n");
                }
            } catch (java.lang.NumberFormatException e)
            {
                System.out.println(e+"\n"+"Input a Integer number\n");
                lib_menu();
            }
        // if -else    
        } else {
            System.out.println("This system has no book information temporarily!\n");
        }
        lib_menu();
    }
    
    public static void del_bk(){
        if (ar1.size() != 0) {
            
            int j = 0;
            System.out.println("Please enter book ID!");
            Scanner inp = new Scanner(System.in);
            try
            {
            int bk_id = inp.nextInt();
            
            for (int i = 0; i < ar1.size(); i++) {
                if (ar1.get(i).getBk_id() == bk_id) {
                    int o_id = ar1.get(i).getBk_id();
                    ar1.remove(i);
                    System.out.println("Book ID:" + o_id + " The book has been deleted successfully!\n");
                    lib_menu();
                    break;
                }
                j++;
            }
            if (j == ar1.size()) {
                System.out.println("This library has no such book ID \n");
            }
            //If -else statement
            }catch (java.util.InputMismatchException e)
            {
                System.out.println(e+"\n"+"Input a 3-digit book number\n");
                lib_menu();
            }
            
        } else {
            System.out.println("This system has no book information temporarily!\n");
        }
        lib_menu();
    }
    
    
}
    



