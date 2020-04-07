package homeworks;

import java.util.ArrayList;
import java.util.List;

 class T {

}
 class A extends T{

}
class B extends A{

}
public class Test {
    public static void main(String[] args){
        List<Class<? extends T>> list = new ArrayList<>();
        System.out.println(list);
    }

}

