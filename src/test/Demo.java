package test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public int a(int i ){
        int b = i+1;
        return b;
    }
    public String b(){
       List<Integer> a = new ArrayList<>();
       return a.toString();
    }
    public static void main(String[] args){
        Demo demo = new Demo();
        System.out.println(demo.b());
    }

}
