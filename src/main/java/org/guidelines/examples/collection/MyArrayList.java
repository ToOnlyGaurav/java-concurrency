package org.guidelines.examples.collection;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
//new ArrayList<>()
        list.add("First");
        list.add("Second");

        for (String element : list) {
            System.out.println(element);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }
}
