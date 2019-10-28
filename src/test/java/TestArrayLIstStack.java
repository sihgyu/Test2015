import com.edu1025.MyArrayListImpl;
import com.edu1025.MyStack;

import java.util.Stack;
import java.util.stream.Stream;

public class TestArrayLIstStack {
    public static void main(String[] args){
        MyStack myStack=new MyStack();
        myStack.push("1111");
        myStack.push(2222);
        myStack.push("3333");
        myStack.push("4444");
        System.out.print("栈顶元素为："+myStack.peek());
        while(myStack.getLength()!=0){
            myStack.pop();
        }
    }
}

