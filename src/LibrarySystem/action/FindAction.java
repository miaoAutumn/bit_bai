package LibrarySystem.action;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

import java.util.Scanner;

public class FindAction implements IAction {
    @Override
    public void work(BookList bookList) {
      System.out.println("执行查找图书操作");
      //用户输入一个书名，进行匹配对应
        System.out.println("请输入您要查找的图书名称");
        Scanner scanner=new Scanner(System.in);
        String bookname=scanner.next();
        //遍历booklist查找图书
        int i=0;
        for (;i<bookList.getSize();i++){
            Book book=bookList.getbook(i);
            if (book.getName().equals(bookname)){
                System.out.println(book);
                break;
            }
        }
        if (i>=bookList.getSize()){
        System.out.println("没有找到相应书籍");
        }
    }
}
