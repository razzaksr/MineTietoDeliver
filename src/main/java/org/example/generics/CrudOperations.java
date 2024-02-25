package org.example.generics;

public interface CrudOperations<T>{
    void create(T object);
    T read(int index);
    String update(int index, T object);
    void view();
    String delete(int index);
}
