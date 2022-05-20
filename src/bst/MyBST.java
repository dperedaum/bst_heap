package bst;

public interface MyBST<T extends Comparable<T>> {

    void add(T value);

    void remove(T value);
}
