package com.edu1025;

import java.util.Iterator;

public interface MyArrayList<E> {
    void add(E object);
    void add(int index,E object);
    boolean remove(E object);
    Object remove(int index);
    int getSize();
    Object get(int index);
    void update(int index,Object obj);
    Iterator<E> iterator();
    boolean contain(Object obj);
}
