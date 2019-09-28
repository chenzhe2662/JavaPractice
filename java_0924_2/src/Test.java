//
//public class Test {
////    给定一个整数数组 nums 和一个目标值 target，
////    请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
////    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//    public static int[] twoSum(int[] nums, int target) {
//        int[] a = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    if (i == j) {
//                        break;
//                    } else {
//                        a[0] = i;
//                        a[1] = j;
//                        return a;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public static double myPow(double x, int n) {
//        double mul=1;
//        if (n == 0) {
//            return 1;
//        } else if (n > 0) {
//            for (int i = n ; i > 0; i--) {
//                mul *= x;
//            }
//            return mul;
//        }
//        for (int i = -n; i > 0; i--) {
//            mul *= x;
//        }
//        return 1 / mul;
//    }
//        public static void main (String[]args){
////        int[] arr={3,2,4};
////        int[] a =twoSum(arr,6);
////        System.out.println(Arrays.toString(a));
//            double ret = myPow(8, -1);
//            System.out.println(ret);
//        }
//    }
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static int mul(int[] arr,int len){
        int max=1;
        if(len<3){
            for(int i=0;i<len;i++){
                max*=arr[i];
            }
        }else if(arr[0]>=0||arr[len-1]<0||
                arr[0]*arr[1]< arr[len-1]*arr[len-2]){
            max=arr[len-1]*arr[len-2]*arr[len-3];
        }else if(arr[0]*arr[1] > arr[len-1]*arr[len-2]){
            max=arr[len-1]*arr[0]*arr[1];
        }
       return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        Scanner c=new Scanner(System.in);
        for(int i=0;i<len;i++){
            arr[i]=c.nextInt();
        }
        Arrays.sort(arr);
        int ret=mul(arr,len);
        System.out.println(ret);
    }
}
