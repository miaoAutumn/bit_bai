package container;

import bit_bai.LinkList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List <String> courses=new ArrayList<>();//向上转型
             // list是一个接口，不能直接使用，所以new一个ArrayList
        courses.add("C语言");//尾插
        courses.add("Java SE");
        courses.add("Java Web");
        courses.add("Java EE");
        //和数组一样，允许添加重复元素
        courses.add("C语言");
        //可以直接按照输入顺序输出，集合类都可以直接打印
        System.out.println(courses);
        //可以类似数组的方式获取指定下标的方式访问
        System.out.println(courses.get(0));//get()获取指定下标元素
        courses.set(0,"数据结构");//set（），修改指定位置的元素
        //get（），set（）方法对顺序表有效，对链表也有效
        System.out.println(courses);//再次打印
        //subList（）方法，截取部分元素[1，3），注意是左闭右开区间
        List<String> subList=courses.subList(0,3);
        System.out.println("截取[0，3）的结果是："+subList);
        //remove（），删除遇到的第一个元素，遇到则删除返回true，没有元素则返回false
        System.out.println(courses.remove("C语言"));
        System.out.println("判断数据结构是否在线性表中："+courses.contains("数据结构"));
        System.out.println(courses);
//       courses.clear();//清空，无返回值

        //重新构造
        List<String> courses2 = new ArrayList<>(courses);
        System.out.println(courses2);
        List<String> courses3 = new LinkedList<>(courses);
        System.out.println(courses3);

        //引用的转换
        ArrayList<String> courses4 = (ArrayList<String>) courses2;
        System.out.println(courses4);//无错
        LinkedList<String> courses5 = (LinkedList<String>) courses3;
        System.out.println(courses5);
//        ArrayList<String> c1 = (ArrayList<String>) courses3;//错误类型
//        LinkedList<String> c2 = (LinkedList<String>) courses2;//错误类型





        }
    }

