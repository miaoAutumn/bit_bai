package homeworks;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args){
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            n = scanner.nextInt();
        }
        System.out.println(Step(n));
    }
    //找到n两边的斐波那契数,看n跟谁的差值更小
    private static int Step(int n) {
        int num = 0;
        int x = 0,y=0;
        while (num>=0){
            if (Fibonacci(num)>=n){
              x = Fibonacci(num);
              break;
            }
            else {
                num++;
            }
        }
        //y是前一个斐波那契数
        y = Fibonacci(num-1);
        return   Math.min(abs(x-n),abs(y-n));
    }

    private static int Fibonacci(int i) {
        if (i == 0){
            return 0;
        }
        else if (i ==1){
            return 1;
        }
        else {
            return Fibonacci(i-1)+Fibonacci(i-2);
        }
    }

}
