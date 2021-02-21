package iterate.list;
 
import java.util.*;
 
/**
 * @author Sridhar
 * There are seven ways to iterate through Java List.
 * 1. Simple For loop
 * 2. Enhanced For loop
 * 3. Iterator
 * 4. ListIterator
 * 5. While loop
 * 6. Iterable.forEach() util
 * 7. Stream.forEach() util
 */
 
public class JavaIterateThroughList {
 
    public static void main(String[] argv) {
 
        // create list
        List<String> javaList = new ArrayList<String>();
 
        // add 4 different values to list
        javaList.add("Facebook");
        javaList.add("Paypal");
        javaList.add("Google");
        javaList.add("Yahoo");
 
        // Other way to define list is - we will not use this list :)
        List<String> javaListNew = Arrays.asList("Facebook", "Paypal", "Google", "Yahoo");
 
        // Simple For loop
        System.out.println("==============> 1. Simple For loop Example.");
        for (int i = 0; i < javaList.size(); i++) {
            System.out.println(javaList.get(i));
        }
 
        // New Enhanced For loop
        System.out.println("\n==============> 2. New Enhanced For loop Example..");
        for (String temp : javaList) {
            System.out.println(temp);
        }
 
        // Iterator - Returns an iterator over the elements in this list in proper sequence.
        System.out.println("\n==============> 3. Iterator Example...");
        Iterator<String> javaIterator = javaList.iterator();
        while (javaIterator.hasNext()) {
            System.out.println(javaIterator.next());
        }
 
        // ListIterator - traverse a list of elements in either forward or backward order
        // An iterator for lists that allows the programmer to traverse the list in either direction, modify the list during iteration,
        // and obtain the iterator's current position in the list.
        System.out.println("\n==============> 4. ListIterator Example...");
        ListIterator<String> javaListIterator = javaList.listIterator();
        while (javaListIterator.hasNext()) {
            System.out.println(javaListIterator.next());
        }
 
        // while loop
        System.out.println("\n==============> 5. While Loop Example....");
        int i = 0;
        while (i < javaList.size()) {
            System.out.println(javaList.get(i));
            i++;
        }
 
        // Iterable.forEach() util: Returns a sequential Stream with this collection as its source
        System.out.println("\n==============> 6. Iterable.forEach() Example....");
        javaList.forEach((temp) -> {
            System.out.println(temp);
        });
 
        // collection Stream.forEach() util: Returns a sequential Stream with this collection as its source
        System.out.println("\n==============> 7. Stream.forEach() Example....");
        javaList.stream().forEach((javaTemp) -> System.out.println(javaTemp));
    }
}