package package_bookmanager.operation;

import package_bookmanager.book.BookList;

public class EixtOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("GoodBye!");
        System.exit(0);
    }
}
