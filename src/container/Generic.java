package container;
public class Generic<E> {//E是一个泛型参数
//    private E[]array;//当前array类型未知，当前不能被直接实例化
//    private int size;

    private Object[] array=new Object[10];//保存顺序表的元素，即Object类型的引用
    private int size;


    public void add(Object ele){//尾插
        array[size]=ele;
        size++;
    }
    public Object get(int index){//得到index位置的元素
        return array[index];
    }
    public static void main(String[] args){
        Generic generic=new Generic();
        //Generic继承自Object类，这是一个向上转型，隐式类型转换，不存在问题
        generic.add("aaa");
       generic.add("bbb");
//        //得到的是一个Object类型的对象，这是向下转型，需要强转为（String）类
       String string=(String)generic.get(0);
//       //为了避免上述强转问题的出现，引入了泛型概念
    }


}
