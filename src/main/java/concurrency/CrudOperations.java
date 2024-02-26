package concurrency;

public interface CrudOperations<T> {

    T create(T object);

    default T read(int id){
        throw new IllegalArgumentException();
    }

    void update(T object);

    default void delete(int id){
        throw new IllegalArgumentException();
    }
}
