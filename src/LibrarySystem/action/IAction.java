package LibrarySystem.action;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

public interface IAction {
    void work(BookList bookList);//接口里面所有方法都是抽象方法，没有{}，不用执行

}
