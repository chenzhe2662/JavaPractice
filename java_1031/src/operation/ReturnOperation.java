package operation;

import book.Book;
import book.BookList;


public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要归还的书名");
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(!book.getName().equals(name)){
                continue;
            }
            if(book.isBorrowed()){
                System.out.println("归还成功");
                book.setBorrowed(false);
                break;
            } else {
                System.out.println("此书已在库");
            }
        }
    }
}
