package LibrarySystem.action;

import LibrarySystem.book.Book;
import LibrarySystem.book.BookList;

import java.util.Scanner;

public class DelAction implements IAction {
    @Override
    public void work(BookList bookList) {
//删除图书
        System.out.println("请输入要删除的图书名称：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        int i=0;
        for (i=0;i<bookList.getSize();i++){
            Book book=bookList.getbook(i);
            if (book.getName().equals(name)){
                break;
            }
        }
        if (i>=bookList.getSize()) {
            System.out.println("未找到对应图书");
        }
        //循环结束时，i就是要删除书籍的下标，将i与最后一个书籍的下标交换，再直接size-1；
        //把删除中间元素改为删除尾部元素，其他元素相对顺序会改变
        int size=bookList.getSize();
        Book book=bookList.getbook(size-1);//最后一本书的信息
        bookList.setbook(i,book);//交换
        bookList.setSize(size-1);//tips，size--，输出的是size，应该用size-1；

    }
}
