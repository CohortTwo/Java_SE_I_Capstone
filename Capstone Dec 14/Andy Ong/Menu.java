/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author andy
 */
public class Menu {
	public static List<Book> database = new ArrayList<>();

	public static void main(String ...args) {
		database.add(new Book(1, "Introducing Maven", 2, "Balaji Varanasi"));
		database.add(new Book(2, "Tmux Taster", 3, "Mark McDonnell"));
		database.add(new Book(3, "Eloquent JavaScript", 4, "Marijn Haverbeke"));

		mainLoop();
	}

	public static void mainLoop() {
		boolean loop = true;
		while (loop) {
			switch (menu()) {
				case 1: for (Book i : database) 
							System.out.println(getBook(i));
						break;
				case 2: System.out.println(getBook(promptID()));
						break;
				case 3: database.add(enterBook());
					 	break;
				case 4: modifyRecord(promptID());
						break;
				case 5: delBook();
						break;
				case 6: loop = false;
						break;
			}
		}
	}

	public static String getBook(Book book) {
		return book.getBookID() + "\t\t" + book.getBookTitle() + "\t\t" + book.getAuthor() + "\t\t" + book.getBorrowerID();
	}

	public static int menu() {
		Scanner input = new Scanner(System.in);
		int selection = 0;
		final String MENU =  
		 "1. List all books\n"
		+"2. Query according to book id\n"
		+"3. Add book\n"
		+"4. Modify book details\n"
		+"5. Delete book\n"
		+"6. Exit";
		while (selection <= 0 || selection > 6) {
			System.out.println( "--------------Student Course Management System-----------");
			System.out.println(MENU);
			System.out.print("Please enter selection: ");
			selection = input.nextInt();
		}
		return selection;
	}

	public static void modifyRecord(Book recordToModify) {
		Book modifiedRecord = enterBook();
		database.remove(recordToModify);
		database.add(modifiedRecord);
	}

	public static Book promptID() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the ID of the book record: ");
		int id = input.nextInt();
		Book target = null;
		for (Book i : database) {
			if (i.getBookID() == id) {
				target = i;
				System.out.println("Book found");
			} 
		}
		return target;
	}

	public static void delBook() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the ID of the book you want to delete: ");
		int id = input.nextInt();
		Book target = null;
		for (Book i : database) {
			if (i.getBookID() == id) {
				target = i;
				System.out.println("Book deleted");
			} 
		}
		database.remove(target);
	}

	public static Book enterBook() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter book ID: "); 
		int id = input.nextInt();
		System.out.print("Enter book title: "); 
		String title = input.next();
		System.out.print("Enter author's name: ");
		String author = input.next();
		System.out.print("Enter borrower's ID: ");
		int borrowerID = input.nextInt();
		return new Book(id, title, borrowerID, author);
	}
}
