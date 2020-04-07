package LibrarySystem.action;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

import java.util.Scanner;

public class AddAction implements IAction {//动作都实现自IAction接口，若要实现方法，只需要重写work方法即可
    @Override
    public void work(BookList bookList) {
        System.out.println("增加图书");
        //用户自行输入
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入图书名称：");
        String name=scanner.next();
        System.out.println("请输入图书价格：");
        int price=scanner.nextInt();
        System.out.println("请输入图书作者：");
        String author=scanner.next();
        System.out.println("请输入图书类型：");
        String type=scanner.next();
        //默认借出状态为未借出
      Book book=new Book(name,price,author,type,false);
      //通过尾插的方式将该书放置图书列表booklist
        int size=bookList.getSize();
        bookList.setbook(size,book);
        bookList.setSize(size+1);
        System.out.println("添加图书成功");
    }
}
