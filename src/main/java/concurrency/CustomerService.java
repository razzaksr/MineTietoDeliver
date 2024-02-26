package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomerService implements CrudOperations<Customer>, Runnable {

    Lock lock=new ReentrantLock();

    public CustomerService(){
        customers.add(new Customer(12,"Razak Mohamed S","razaksrmd@gmail.com"));
        customers.add(new Customer(7,"Rasheedha R","rasheedharmohamed@gmail.com"));
        customers.add(new Customer(4,"Rajiya R","rahiyarmohamed@gmail.com"));
    }

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer read(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Customer customer) {
        int index = customers.indexOf(customer);
        if (index != -1) {
            customers.set(index, customer);
        }
    }

    @Override
    public void delete(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
    Scanner scanner=new Scanner(System.in);
    @Override
    public void run() {
        lock.lock();
        System.out.println("Welcome admin "+Thread.currentThread().getName());
        System.out.println("Enter the process to proceed by "+Thread.currentThread().getName());
        String process= scanner.next();
        switch (process){
            case "read":
                System.out.println("Enter the customer id");
                System.out.println(read(scanner.nextInt()));
                break;
            case "delete":
                System.out.println("Enter the customer id");
                delete(scanner.nextInt());
                break;
            case "view":
                System.out.println(customers);break;
        }
        lock.unlock();
    }
}