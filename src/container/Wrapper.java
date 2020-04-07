package container;

public class Wrapper {
    //装箱拆箱实际上是一种类型转换
    int i1=10;

    //手动装箱,创建一个Integer类型的对象，将i1的值放入到这个对象的属性中去
    //valueOf是静态方法，静态方法用类名调用
    Integer i2=Integer.valueOf(i1);
    Integer i3=new Integer(i1);
    //手动拆箱,将Inter类型的对象从值中取出，放入基本数据类型int中
    int i4=i2.intValue();


    int j1=20;
    //自动装箱，类似于一个隐式的类型转换,可以直接把int赋值给Integer
    Integer j2=j1;
    Integer j3=(Integer)j1;
    //自动拆箱
    int j4=j2;
    int j5=(int)j2;

}
