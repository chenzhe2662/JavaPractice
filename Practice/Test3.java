public class  Test3{
   //将数组A中的内容和数组B中的内容进行交换。
    public void swap(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            int tmp = a[i];
            a[i]=b[i];
            b[i]=tmp;
        }
    }
    public void print(int[] a){
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
    public double Sum(int n){
        int flag=1;
        double sum=0;
        for(int i=1;i<=n;i++){
            sum+=flag*(1.0/i);
            flag=-flag;
        }
        return sum;
    }
    public static void main(String[] args) {
        Test3 s= new Test3();
        double ret=s.Sum(100);
        System.out.println(ret);
        // int[] a={1,3,5,7,9};
        // int[] b={0,2,4,6,8};
        // Test3 s= new Test3();
        // s.swap(a, b);
        // s.print(a);
        // s.print(b);
    }
}