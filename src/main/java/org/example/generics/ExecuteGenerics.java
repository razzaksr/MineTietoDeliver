package org.example.generics;

public class ExecuteGenerics {
    public static void main(String[] args) {
        CrudImplementation<Integer> intImplement=new CrudImplementation<>();
        intImplement.myObjects=new Integer[4];
        intImplement.create(12);intImplement.create(45);
        intImplement.create(98);intImplement.create(66);
        intImplement.view();
        System.out.println(intImplement.delete(3));
        System.out.println(intImplement.read(3));
        CrudImplementation<String> stringImplement=new CrudImplementation<>();
        stringImplement.myObjects=new String[3];
        stringImplement.create("Razak Mohamed S");stringImplement.create("Rasheedha R");
        stringImplement.create("Rajiya R");
        stringImplement.view();
        System.out.println(stringImplement.update(2,"Rajiya R Mohamed"));
        System.out.println(stringImplement.read(2));
    }
}
