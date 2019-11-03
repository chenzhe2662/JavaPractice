package operation;

import book.Book;
import book.BookList;



public class BorowedOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入书名：");
        String name = scanner.next();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getBook(i);
            if(!book.getName().equals(name)) {
                //book.setBorrowed(true);
                continue;
            }
            if(book.isBorrowed()){
                System.out.println("这本书已经被借走");
            } else {
                book.setBorrowed(true);
                System.out.println("借书成功");
            }
        }
    }
}
