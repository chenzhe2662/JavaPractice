import java.util.Scanner;

public class Main {
    public static void reverse(char[] arr ,int start ,int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    public static String reverse(char[] arr , int size) {
        reverse(arr,0,size - 1);
        reverse(arr,size,arr.length - 1);
        reverse(arr,0,arr.length - 1);
        return  new String(arr);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int size = scanner.nextInt();
        char[] arr = str.toCharArray();
        System.out.println(reverse(arr,size));
    }

}
