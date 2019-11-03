package operation;

import book.Book;
import book.BookList;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要查找的书名：");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        if (i >= bookList.getUsedSize()) {
            //没找到
            System.out.println("未找到要删除的书籍");
        }
        System.out.println("查找完毕");
    }
}
