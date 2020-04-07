package homeworks;

public class Trycatch {
    public static void main(String[] args) {
        try{
            func();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
    public static void func(){
        int [] arr={1,2,3};
        System.out.println(arr[100]);
    }
}
