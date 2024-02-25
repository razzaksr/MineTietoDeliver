package org.example.generics;

import java.util.Arrays;

public class CrudImplementation<T> implements CrudOperations<T>{
    T[] myObjects;
    @Override
    public void create(T object) {
        for(int index=0;index< myObjects.length;index++){
            if(myObjects[index]==null){
                myObjects[index]=object;
                System.out.println(object+" has inserted");
                return;
            }
        }
        System.out.println(object+" hasn't inserted");
    }

    @Override
    public T read(int index) {
        if(index>=0&&index< myObjects.length)
            return myObjects[index];
        return null;
    }

    @Override
    public String update(int index, T object) {
        if(index>=0&&index< myObjects.length){
            myObjects[index]=object;
            return object+" has updated";
        }
        return object+" hasn't updated";
    }

    @Override
    public void view() {
        System.out.println(Arrays.toString(myObjects));
    }

    @Override
    public String delete(int index) {
        if(index>=0&&index< myObjects.length){
            T object=myObjects[index];
            myObjects[index]=null;
            return object+" has deleted";
        }
        return "Invalid index "+index;
    }
}
