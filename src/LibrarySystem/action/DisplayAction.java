package LibrarySystem.action;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

public class DisplayAction implements IAction {
    @Override
    public void work(BookList bookList) {//重写抽象方法
        System.out.println("书籍如下");
    for (int i=0;i<bookList.getSize();i++){
        Book book=bookList.getbook(i);
        System.out.println(book);
    }

    }
}
