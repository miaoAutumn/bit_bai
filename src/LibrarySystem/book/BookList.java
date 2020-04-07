package LibrarySystem.book;

public class BookList {
    //相当于一个顺序表，用来存储书的元素
    private Book [] books=new Book[100];
    //数组中有效元素的个数
    private int size=0;

    public BookList() {
        //默认添加几个数据，方便后续测试
        books[0]=new Book("三国演义", 100,"罗贯中",
                "历史刊物",true);
        books[1]=new Book("西游记",150,"吴承恩",
                "历史刊物",false);
        books[2]=new Book("红楼梦",200,"曹雪芹",
                "历史名著",false);
        size=3;
    }
    public Book getbook(int pos){
        return books[pos];
    }
    public void setbook(int pos,Book book) {
        books[pos] = book;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}

