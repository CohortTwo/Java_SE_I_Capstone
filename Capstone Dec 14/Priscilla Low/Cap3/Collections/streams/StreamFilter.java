/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author blueg
 */
public class StreamFilter {
    public static void main(String[] args) {
        
        List<Product> myList = new ArrayList<Product>();
        //Adding Products  
        myList.add(new Product(1,"HP Laptop",25000f));  
        myList.add(new Product(2,"Dell Laptop",30000f));  
        myList.add(new Product(3,"Lenevo Laptop",38000f));  
        myList.add(new Product(4,"Sony Laptop",28000f));  
        myList.add(new Product(5,"Apple Laptop",90000f));  
        
        myList.stream()
                .filter(p->p.price>30000f)
                .map(pm->pm.name)
                .forEach(System.out::println);
        

    }
}

class Product{
    int id;  
    String name;  
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
    
}