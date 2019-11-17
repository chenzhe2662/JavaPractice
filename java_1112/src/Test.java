
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static List<Character> searchNoteRepeat(String str1 , String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!str2.contains(str1.charAt(i) + "")) {
                characters.add(str1.charAt(i));
            }
        }
        return characters;
    }

    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        System.out.println(searchNoteRepeat(str1 , str2));

    }
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        if ( arr.length == 0) {
            return null;
        }
        int  i = 0;
        int len = s.length() / k;
        while (len > 0) {
            reverse(arr,i,k + i - 1);
            i += k;
            len --;
        }
        return  String.valueOf(arr);
    }
    public static void reverse(char[] arr ,int start ,int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main6(String[] args) {
        String str = "abcdefg";
        System.out.println(reverseStr(str,2));
    }
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        String str1 = "aeiouAEIOU";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            list.add(str1.charAt(i) + "");
        }
        System.out.println(list);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while ( left < right && (!list.contains(arr[left] + ""))){
                left++;
            }
            while (left < right&&(!list.contains(arr[right] + "") )){
                right--;
            }
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main5(String[] args) {
        String str = "hello";
        System.out.println(reverseVowels(str));
    }
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < str.length(); i++) {
            if ((str.charAt(i) >= 'a'&& str.charAt(i) <= 'z')
                || (str.charAt(i) >= '0'&& str.charAt(i) <= '9')) {
               builder.append(str.charAt(i));
            }
        }
        String str1 = builder.toString();
        String str2 = builder.reverse().toString();
       return str1.equals(str2);
    }

    public static void main3(String[] args) {
        String str = "hello world";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
        }
        System.out.println(builder);
    }
    public static void main4(String[] args) {
        String str = "0p";
        System.out.println(isPalindrome(str));
    }
    public static void main2(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<String> list1 = new LinkedList<>();
        for (int i = 0; i < str1.length(); i++) {
            list1.add(str1.charAt(i) + "");
        }
        List<String> list2 = new LinkedList<>();
        for (int i = 0; i < str2.length(); i++) {
            list2.add(str2.charAt(i) + "");
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                list1.remove(list1.get(i));
                i--;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s:list1) {
            builder.append(s);
        }
        System.out.println(builder);
    }
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(7);
        list.add(4);
        list.add(6);
        list.add(8);
        Collections.sort(list);
        System.out.println(list);
    }
}
