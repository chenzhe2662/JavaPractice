package package_bookmanager.user;

import package_bookmanager.operation.*;

import java.util.Scanner;

public class NomalUesr extends User {
    public NomalUesr(String name) {
        super(name);
        operations = new IOperation[]{
                new EixtOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    @Override
   public int menu() {
        System.out.println("=================");
        System.out.println("HELLO :" + name);
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("0. 退出");
        System.out.println("=================");
        System.out.println("请输入你的操作：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
