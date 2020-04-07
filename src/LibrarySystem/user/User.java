package LibrarySystem.user;

import LibrarySystem.action.IAction;
import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

//User不需要去创建实例，真正要创建实例对象的是NormalUser和Admini
//所以把User类设置为抽象类
//但是不能把User设置成接口，因为User里面还要包含具体操作
abstract public class User {
    protected String name;
    //用来存放用户都支持的操作
    protected IAction [] actions;
//打印一个命令行菜单
    //因为普通用户和管理员之间的操作存在差异，所以他两的交互菜单也存在差异
    //所以要在普通用户和管理员中分别实现各自的交互菜单
    abstract public int menu();
    //公共的每种用户都需要的方法
    public void doAction(int choice, BookList bookList){
        //choice是用户通过命令行窗口输入的选项
        //根据输入的选项在数组中找到合适的操作
        actions[choice].work(bookList);//多态的思想去实现各个动作

    }



}
