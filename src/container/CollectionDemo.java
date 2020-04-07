package container;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args){
     //ArrayList是顺序表，这是一个向上转型
     // 实际上new的对象是ArrayList，使用父类Collection类的引用来保存这个对象
     //String是一个泛型参数，collection中包含着若干的String对下对象
     // <>里面可以是合法数据类型，根据需要改为对应的类型
        Collection<String> list=new ArrayList<>();
        System.out.println(list.size());//返回集合中的元素个数 null
        System.out.println(list.isEmpty());//判断是否为空集合 true
         list.add("武");//插入一个String类型元素
        ((ArrayList<String>) list).add("汉");
        ((ArrayList<String>) list).add("加油");
        System.out.println(list.size());//3
        System.out.println(list.isEmpty());//false
        //toArray:返回一个装有所有集合中元素的数组，可以把collect变成数组
        Object [] array=list.toArray();
        String string= Arrays.toString(array);
        System.out.println(string);//数组不能直接被输出需要遍历，但是字符串可以
        for (String s : list) {
            System.out.println(s);
        }
        ((ArrayList<String>) list).remove("加油");
        System.out.println(list);
        list.clear();//删除所有元素
        System.out.println(list);
        System.out.println(list.isEmpty());//true
    }
}
