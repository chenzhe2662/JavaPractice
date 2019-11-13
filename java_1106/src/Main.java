import java.util.Arrays;

public class Main {
    public static int balancedStringSplit(String s) {
        int stack = 0;
        int count = 0;
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch == 'L') {
                stack++;
            }else {
                stack--;
            }
            if (stack == 0) {
                count++;
            }
        }
        return count;
    }
    public static String defangIPaddr(String address) {
        String s = address.replaceAll("\\.", "[.]");
        return s;
    }

    public static void main(String[] args) {
        String str = "196.168.1.1";
        String ret = defangIPaddr(str);
        System.out.println(ret);
    }
    public static void reverse(String[] arr ) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            String tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main1(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        String str = "i am a student";
        String[] arr = str.split(" ");
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i != arr.length - 1) {
                builder.append(" ");
            }
        }
        builder.reverse();
        System.out.println(builder);
    }
}
