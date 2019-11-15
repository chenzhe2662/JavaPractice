import java.util.ArrayList;
import java.util.List;

public class Test {
    public static String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char s : arr) {
            if (s >= 'A' && s <= 'Z') {
                s += 32;
            }
            builder.append(s);
        }
        return builder.toString();
    }
    public static String[] uniqueMorseRepresentations(String[] words) {
        String[] strings = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};
        StringBuilder builder = new StringBuilder();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                int tmp = s.charAt(i) - 'a';
                builder.append(strings[tmp]);
            }
            builder.append(",");
        }
        String str = builder.toString();
        String[] strings1 = str.split(",");
        return strings1;
    }
    public static List<String> generateParenthesis(int n) {

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(")");
            strings.add(0,"(");
        }
        return strings;
    }

    public static String reverseWords(String s) {
        char[] arr  = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        String str = new String(arr);
        String[] strings = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1 ; i >= 0;i--)  {
            builder.append(strings[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
//        List<String> strings = new ArrayList<>(generateParenthesis(3));
//        System.out.println(strings);
//        String[] arr = {"gin", "zen", "gig", "msg"};
//        String[] arr1 = uniqueMorseRepresentations(arr);
//        System.out.println(Arrays.toString(arr1));
//        String str = "Hello";
//        System.out.println(toLowerCase(str));
    }
}
