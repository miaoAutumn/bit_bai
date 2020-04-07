package LibrarySystem.book;

public class Book {
    private String name;
    private int price;
    private String author;
    private String type;
    //是否被借出
    private boolean isborrowed;

    public Book(String name, int price, String author, String type, boolean isborrowed) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.type = type;
        this.isborrowed = isborrowed;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public boolean isborrowed() {
        return isborrowed;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIsborrowed(boolean isborrowed) {
        this.isborrowed = isborrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", isborrowed=" + isborrowed +
                '}';
    }
}
