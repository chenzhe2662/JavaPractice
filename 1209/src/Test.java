import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Throwable {
        Thread.sleep(99999999);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int f1 = 0;
        int f2 = 1;
        while (f2 <= input) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        int ret = f2 - input > input - f1 ?
                input - f1 : f2 - input;
        System.out.println(ret);


        Scanner scanner1 = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner1.hasNext()) {
            String str = scanner1.nextLine();
            String arr[] = str.split(" ");
            for(int i=0; i<arr.length; i++){
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }

}