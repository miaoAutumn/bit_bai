package container;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyboard {
    public static void main(String[] args) {
        //牛客网中，用例都是多次循环输入的
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            //1.循环读入两个字符串，第一个字符串是期待字符串，第二个字符串是坏键实际输出字符串
            String expect = scanner.next();
            String actual = scanner.next();
            //2.把读入的两个字符串全部转换为大写（在牛客网输出示例中是大写）
            expect = expect.toUpperCase();
            actual = actual.toUpperCase();
           //3.把实际输出的字符入set
            Set<Character> actualSet = new HashSet<>();
            char[] actual1 = actual.toCharArray();
            for (int i=0;i<actual1.length;i++){
                actualSet.add(actual1[i]);
            }
            //4.遍历预期数组，看看哪个字符没有在set中，如果没有在set中就输出它
            Set<Character> brokenKeySet = new HashSet<>();
            char [] expect1 = expect.toCharArray();
            for (int j=0;j<expect1.length;j++){
                if (actualSet.contains(expect1[j])){
                    //如果set里面有期望字符，就继续循环，说明字符被输出了，是个好键
                    //不执行任何操作，进入对下一个键的循环判断中
                    continue;
                }
                //如果set里面没有期望字符，说明字符没有被输出，是个坏键,就输出它
                //注意牛客的输出格式，不要空格，不要换行，细节是魔鬼
                //输出之前要对坏键进行去重操作,此处brokenKeySet用来进行去重操作
                if (brokenKeySet.contains(expect1[j])){
                    //如果在brokenSet里面之前没有过该键，就直接输出
                   continue;
                }
                System.out.print(expect1[j]);
                brokenKeySet.add(expect1[j]);
            }

        }

    }
}
