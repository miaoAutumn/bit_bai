package LibrarySystem.user;

import LibrarySystem.action.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {//重写构造方法
        this.name=name;//进行初始化
        this.actions=new IAction[]{//初始化对象,对应普通用户所进行的操作
                new ExitAction(),
                new FindAction(),
                new BorrowAction(),
                new ReturnAction(),

        };
    }

    @Override
    public int menu() {//重写抽象方法
        System.out.println("=====================");
        System.out.println("欢迎"+this.name+"使用图书馆管理系统");
        //用户输入的选项与下标相对应
        System.out.println("1.查找图书");
        System.out.println("2.借书");
        System.out.println("3.还书");
        System.out.println("0.退出系统");
        System.out.println("=====================");
        //让用户输入一个选项
        System.out.println("请在此处输入您的选项");
        int choice=0;
        //键盘录入器
        Scanner scanner=new Scanner(System.in);
        choice=scanner.nextInt();
        return choice;
    }
}
