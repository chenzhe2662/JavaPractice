//写代码实现: 给定两个 int 变量, 交换变量的值.
class Swap{
    int a = 10;
    int b = 20;

}
public class Test {
    // 写代码实现: 给定三个 int 变量, 求其中的最大值和最小值
    public static void main(String[] args)  {
        Swap s = new Swap();
        int  tem = s.a;
        s.a=s.b;
        s.b=tem;
        System.out.println(s.a+","+s.b);
    }
}
