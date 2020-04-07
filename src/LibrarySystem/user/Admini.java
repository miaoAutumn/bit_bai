package LibrarySystem.user;
//管理员类
import LibrarySystem.action.*;
import java.util.Scanner;

public class Admini extends User {
    public Admini(String name) {
        this.name=name;
        this.actions=new IAction[]{
                new ExitAction(),
                new FindAction(),
                new AddAction(),
                new DelAction(),
                new DisplayAction(),
        };
    }

    @Override
    public int menu() {
        System.out.println("=================");
        System.out.println("欢迎"+this.name+"使用图书馆管理系统，您是管理员");
        //用户输入的选项与下标相对应
        System.out.println("1.查找图书");
        System.out.println("2.增加书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");
        System.out.println("=====================");
        //让用户输入一个选项
        System.out.println("请在此处输入您的选项");
        //键盘录入器
        int chioce=0;
        Scanner scanner=new Scanner(System.in);
        chioce=scanner.nextInt();
        return chioce;
    }
}
