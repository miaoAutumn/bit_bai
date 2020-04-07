package LibrarySystem.action;

import LibrarySystem.book.BookList;

public class ExitAction implements IAction {
    @Override
    public void work(BookList bookList) {
System.out.println("系统退出，goodbye！！");
    }
}
