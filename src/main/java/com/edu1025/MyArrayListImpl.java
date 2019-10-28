package com.edu1025;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListImpl<E> implements MyArrayList<E>{
    // 定义属性,transient关键字标记的成员变量不参与序列化过程
    private transient Object[] elementData;
    // ArrayList实际数量
    private int size;

    //构造方法
    public MyArrayListImpl() {
        this(10);
    }

    public MyArrayListImpl(int initialCapacity) {
        if(initialCapacity<0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        elementData = new Object[initialCapacity];
    }
//添加元素
    public void add(E object) {
        ensureExplicitVapacity(size+1);
        elementData[size++]=object;
    }

    public void add(int index, E object) {
        rangeCheck(index);
        ensureExplicitVapacity(size+1);
        System.arraycopy(elementData, index, elementData, index+1, size);
        elementData[index]=object;
        size++;
    }
//删除元素
    public boolean remove(E object) {
        for(int i=0;i<elementData.length;i++){
            Object element=elementData[i];
            if(element.equals(object)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public Object remove(int index) {
        Object object=get(index);
        int numMoved = elementData.length-index-1;
        if(numMoved>0){
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        elementData[--size]=null;
        return object;
    }
//获得元素的个数
    public int getSize() {
        return size;
    }
//获取指定位置的元素
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 更新
     */
    public void update(int index, Object obj) {
        rangeCheck(index);
        remove(index);
        E e =(E)obj;
        add(e);
    }

    /**
     * 扩容
     */
    public void ensureExplicitVapacity(int minCapacity){
        if(size==minCapacity){
            int oldCapacity=elementData.length;
            int newCapacity=oldCapacity+(oldCapacity >>1);
            if(newCapacity<minCapacity){
                newCapacity=minCapacity;
            }
            elementData= Arrays.copyOf(elementData,newCapacity);
        }

    }
    /**
     * 检测数组是否下标越界
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("length--->"+index);
        }
    }
    //迭代器
    @Override
    public Iterator<E> iterator() {

        //内部类——迭代器
        class Itr implements Iterator<E> {
            int cursor;       // index of next element to return
            int lastRet = -1; // index of last element returned; -1 if no such
            int expectedModCount = size;

            public boolean hasNext() {
                return cursor != size;
            }

            @SuppressWarnings("unchecked")
            public E next() {
                checkForComodification();
                int i = cursor;
                if (i >= size)
                    throw new NoSuchElementException();
                Object[] elementData = MyArrayListImpl.this.elementData;
                if (i >= elementData.length)
                    throw new ConcurrentModificationException();
                cursor = i + 1;
                return (E) elementData[lastRet = i];
            }

            public void remove() {
                if (lastRet < 0)
                    throw new IllegalStateException();
                checkForComodification();

                try {
                    MyArrayListImpl.this.remove(lastRet);
                    cursor = lastRet;
                    lastRet = -1;
                    expectedModCount = size;
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }

            final void checkForComodification() {
                if (size != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        }
        //返回迭代器
        return new Itr();
    }
    //是否包含某元素
    @Override
    public boolean contain(Object obj){
        for (int i=0;i<getSize();i++){
            if(obj.equals(get(i))){
                return true;
            }
        }
        return false;
    }
}
