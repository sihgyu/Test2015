package com.edu1025;

public class MyStack {
    MyArrayListImpl arrayList =new MyArrayListImpl();
    //入栈
    public void push(Object obj){
        arrayList.add(obj);
    }
    //出栈
    public void pop(){
        Object obj=null;
        if(arrayList.getSize()!=0){
            obj=arrayList.get(arrayList.getSize()-1);
            System.out.println(obj);
            arrayList.remove(obj);
        }else{
            return;
        }
    }
    //获取栈的元素个数
    public int getLength(){
        return arrayList.getSize();
    }
    //查看栈顶元素
    public Object peek() {
        if (arrayList != null && arrayList.getSize() > 0) {
            return arrayList.get(arrayList.getSize() - 1);
        }
        return null;
    }
}
