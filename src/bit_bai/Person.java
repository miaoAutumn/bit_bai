package bit_bai;

public class Person {
    int a=5;
    public void play(){
        System.out.println("Person play...");
    }
}
class Boy extends Person{
    @Override
    public void play(){
        System.out.println("boy play...");
    }
    public void run(){
        System.out.println("run play...");
    }
}
class baby extends Boy{
    @Override
    public void play(){
        System.out.println("baby play...");
        super.run();
    }

}
class RunMain{
    public static void main(String[] args){
        Person b = new Boy();//向上转型
        b.play();
        System.out.println("-------------------------");
        Boy b1 =(Boy)b;//向下转型
        b1.play();
        b1.run();
        Person b3 = new baby();//爷爷类型引用指向孙子类型对象，向上转型
        b3.play();
    }
}
