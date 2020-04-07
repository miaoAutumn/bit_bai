package LibrarySystem;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;
import LibrarySystem.user.Admini;
import LibrarySystem.user.NormalUser;
import LibrarySystem.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.先给一个数据
        BookList bookList = new BookList();
        //2.创建一个用户并登陆
//因为User是抽象类不能实例化对象所以调用login方法b
        User user = Login();
        //3.进入循环
        while (true) {
            //4.在主循环里调用menu方法显示用户菜单，menu方法就是为了得到一个用户输入的选项
            int choice = user.menu();//动态绑定，代码对自动匹配相应的user
            //5.根据用户输入的choice来决定执行哪个IAction对象
            user.doAction(choice,bookList);
        }

    }
    //向上转型
    public static User Login() {
        //提示用户进行登陆
        System.out.println("请输入您的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入您的身份信息：1.代表管理员，2.代表普通用户");
        int who = scanner.nextInt();
        if (who == 1) {
            return new Admini(name);
        } else {
            return new NormalUser(name);
        }

    }
}

