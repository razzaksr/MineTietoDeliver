package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoComparatorWithDynamicOrder {
    public static String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting criteria (name, price, quantity): ");
        String criteria = scanner.nextLine();
        System.out.println("Choose order (ascending/descending): ");
        String order = scanner.nextLine();

        // Validate input (e.g., check for valid criteria and order options)
        return criteria + "-" + order;
    }

    public static void main(String[] args) {
        Product product1=new Product("Rebok",1234.5,12);
        Product product2=new Product("Nike",982.4,40);
        Product product3=new Product("Adidas",2456.5,2);
        Product product4=new Product("Puma",9845.2,40);
        ArrayList<Product> list= (ArrayList<Product>) Stream.of(product1,product2,product3,product4).collect(Collectors.toList());

//        String userChoice = getUserChoice();
//        ProductComparator comparator = new ProductComparator(userChoice);
//        Collections.sort(list, comparator);

        // printing list
        //System.out.println(list);
        //list.forEach(System.out::println);// using method reference
        //list.forEach(each-> System.out.println(each));// using lambda

        //list.stream().map(v-> v.getPrice()<=10000).forEach(v-> System.out.println(v));

        // filter based price and print
        list.stream().filter(v->v.getPrice()<=5000).forEach(System.out::println);
    }
}
