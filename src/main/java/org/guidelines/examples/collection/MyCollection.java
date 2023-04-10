package org.guidelines.examples.collection;

import java.util.Iterator;

public interface MyCollection<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    boolean add(E e);
}
