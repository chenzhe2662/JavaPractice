import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str = "123456";
        char[] arr = str.toCharArray();
        for (int str2:arr) {
            if (str2 < '0' || str2 > '9') {
                System.out.println(false);
            }
        }
    }
    public static void main14(String[] args) {
        String str = "helloworld";
        char[] arr = str.toCharArray();
        System.out.println(arr[0]);
        arr[0] = 'H';
        arr[5] = 'W';
        System.out.println(Arrays.toString(arr));
        String str2 = new String(arr);
        System.out.println(str2);
    }
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        String str ;
        for (int i = 0; i < len1 - len2; i++) {
            str = haystack.substring(i,len2 + i);
            if (str.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0,str.length() - 1);
                if (str.isEmpty()) {
                    return "";
                }
            }
        }
        return str;
    }

    public static void main13(String[] args) {
       int ret = strStr("wohellowored","hello");
        System.out.println(ret);
    }
    public static void main12(String[] args) {
        int a = 0;
        String str1 = "hello" + a;
        String str2 = "hello0";
        String str = "helloworld";
        System.out.println(str.indexOf("helloJava"));
        System.out.println(str.length());
    }
    public static void main11(String[] args) {
        String[] str = {
                "hellocjnksv",
                "helloacnvjhi",
                "hellosvnsibui"
        };
        String ret = longestCommonPrefix(str);
        System.out.println(ret);
//        System.out.println(fistUpper("i am a boy!"));
//        System.out.println(fistUpper(""));
//        System.out.println(fistUpper("a"));

    }
    public static String fistUpper(String str) {
        if ("".equals(str) || str == null) {
            return str;
        }
        if (str.length() > 1) {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
        return str.toUpperCase();
    }

    public static void main10(String[] args) {
        String str = " hello  world             ";
        System.out.println("[" + str + "]");
        System.out.println("[" + str.trim() + "]");
        String str1 = "Hello%$#@%^&World   呵呵   ";
        System.out.println(str1.toUpperCase());
        System.out.println(str1.toLowerCase());
        //String str2 = "hello";
        System.out.println("hello".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(new String().isEmpty());
    }
    public static void main9(String[] args) {
        String str = "name=chenzhe&age=18";
        String[] res = str.split("&");
        for (int i = 0; i < res.length; i++) {
            String[] temp = res[i].split("=");
            System.out.println(temp[0] + " = " + temp[1]);
        }
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public static void main8(String[] args) {
        String str = "hello wolrd chen zhe";
        String[] s1 = str.split(" ");
        String[] s2 = str.split(" ",3);//数组长度 limit
        for (String s : s1) {
            System.out.print(s + "|");
        }
        System.out.println();
        for (String s: s2) {
            System.out.print(s + "|");
        }
        String str1 = "192.168.1.1";
        String[] s3 = str1.split("\\.");//
        System.out.println();
        for (String s : s3) {
            System.out.print(s + "|");
        }
    }
    public static void main7(String[] args) {
        int[] arr = {'a','A',9};
        for (int i:arr) {
            System.out.print(i + " ");
        }
    }
    public static void main6(String[] args) {
        String str = "hello";
        String str1 = "Hello";
        String str2 = "hello";
//        System.out.println(str.equals(str1));
//        System.out.println(str.equals(str2));
//        System.out.println(str.equalsIgnoreCase(str1));
//        System.out.println(str.equalsIgnoreCase(str2));
        System.out.println("a".compareTo("A"));
        System.out.println("A".compareTo("a"));
        System.out.println("A".compareTo("A"));
        System.out.println("AB".compareTo("AC"));
        System.out.println("陈".compareTo("李"));
    }

    public static void main5(String[] args) {
        String str = "abcde";
        byte[] arr = str.getBytes();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(new String(arr));
    }
    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main4(String[] args) {
        String str = "124gvd56";
        System.out.println(isNumber(str)? "字符串全是数字":"字符串不全是数字");
    }
    public static void main3(String[] args) {
        String str = "hello";
       // System.out.println(str.charAt(0));
        //System.out.println(str.charAt(10));
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(new String(arr));
        System.out.println(new String(arr,1,3));
    }
    public static void main2(String[] args) {
        String str = "hello";
        String str1 = "hello";
        System.out.println(str == str1);
        String str2 = new String("String");
        String str3 = new String("String");
        System.out.println(str2 == str3);
     }
    public static void main1(String[] args) {
        String str = "hello world!";
        String str1 = new String("hello girl!");
        char[] arr = {'a','b','c'};
        String str2 = new String(arr);
        System.out.println(str + " " + str1 +" " + str2);

    }
}
