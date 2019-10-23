package package_bookmanager.operation;

import package_bookmanager.book.Book;
import package_bookmanager.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除数据");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的序号：");
        String id = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getId().equals(id)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            //没找到
            System.out.println("未找到要删除的书籍");
            return;
        }
        //找到了之后用最后一个
        //元素覆盖当前元素，在删除最后一个
        Book lastBook = bookList.getBook(bookList.getSize()-1);
        bookList.setBook(i,lastBook);
        bookList.setSize(bookList.getSize()-1);
        System.out.println("删除成功");
    }
}
