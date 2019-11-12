public class Test {
    public static String reverse (String str) {
        char[] arr = str.toCharArray();
        int right = 0;
        int left = arr.length - 1;
//        while (right < left) {
//            char tmp = arr[right];
//            arr[right] = arr[left];
//            arr[left] = tmp;
//            right++;
//            left--;
//        }
        return new String(arr);
    }
    public static void main(String[] args) {
        String str = "abcdef";
        String str1 = reverse(str);
        System.out.println(str1);
    }
}
