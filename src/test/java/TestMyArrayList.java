import com.edu1025.MyArrayListImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayListImpl<String> list = new MyArrayListImpl<String>();
        list.add("猪八戒");
        list.add("孙悟空");
        list.add("沙和尚");
        System.out.println("--------新增------------");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------获取元素的个数------------");
        System.out.println(list.getSize());

        System.out.println("--------用迭代器遍历集合------------");
        Iterator it=list.iterator();
        while(it.hasNext()) {							//集合中的迭代方法(遍历)
            System.out.println(it.next());
        }

        System.out.println("--------测试集合中是否包含某元素------------");
        System.out.println( list.contain("猪八戒"));
        System.out.println( list.contain("白龙马"));

        list.update(0, "唐僧");
        System.out.println("--------替换指定位置的元素------------");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
        list.add("白骨精");
        list.add("狐狸精");
        System.out.println("--------删除------------");
        System.out.println("删除前：");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(3);
        System.out.println("删除后：");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }

}
