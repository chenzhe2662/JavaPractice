package package_bookmanager.user;


import package_bookmanager.book.BookList;
import package_bookmanager.operation.IOperation;

abstract public class User {

    protected String name;

    public User(String name) {
        this.name = name;
    }

    protected IOperation[] operations;

    abstract public int menu();

    //根据输入选项调对应操作
    public void doOperation(int choice , BookList bookList) {
        operations[choice].work(bookList);
    }
}

