package package_bookmanager.book;

public class Book {
    private String name;//书名
    private String id;//编码
    private String author;//作者
    private int price;//价格
    private String type;//类型
    private boolean isBorrowed;//是否被借出

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Book(String name, String id, String author,
                int price, String type, boolean isBorrowed) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "【" +
                "name：'" + name + '\'' +
                ", id：'" + id + '\'' +
                ", author：'" + author + '\'' +
                ", price：" + price +
                ", type：'" + type + '\'' +
                ", isBorrowed：" + isBorrowed +
                '】';
    }
}
