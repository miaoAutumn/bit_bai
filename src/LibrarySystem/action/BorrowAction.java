package LibrarySystem.action;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行借书操作");
        System.out.println("请输入您要借出的书籍：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getbook(i);
            if (book.getName().equals(bookname)) {
                if (book.isborrowed()) {
                    System.out.println("本书已经被借出");
                    break;
                } else {
                    book.setIsborrowed(true);
                    System.out.println("借书成功");
                }
            }
        }
        //如果书名不存在或者图书已经被借出
        if (i >= bookList.getSize()) {
            System.out.println("没有匹配的书籍或图书已经被借出");
        }

    }
}
