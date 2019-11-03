package operation;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入新增书名：");
        String name = scanner.next();
        System.out.println("请输入作者：");
        String author = scanner.next();
        System.out.println("请输入价格：");
        int price = scanner.nextInt();
        System.out.println("请输入类型：");
        String type = scanner.next();
        Book book = new Book(name,author,price,type);
        bookList.setBook(bookList.getUsedSize(),book);
        bookList.setUsedSize(bookList.getUsedSize() + 1);
    }
}
