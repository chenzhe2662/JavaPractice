package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入删除的书名：");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getUsedSize()) {
            //没找到
            System.out.println("未找到要删除的书籍");
            return;
        }
        Book lastbook = bookList.getBook(bookList.getUsedSize() - 1);
        bookList.setBook(i,lastbook);
        bookList.setUsedSize(bookList.getUsedSize() - 1);
        System.out.println("删除成功");
    }
}
