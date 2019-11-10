import java.util.ArrayList;
import java.util.List;

public class Demo {
    //第一行固定，只有一个1
    //第二行固定，只有两个1
    //任意一行头尾是1
    //第i行有i列
    //第i行的第j列是i-1，j-1列和j列相加
    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        res.add(firstLine);
        if (numRows == 1) {
            return res;
        }
        List<Integer> seconedLine = new ArrayList<>();
        seconedLine.add(1);
        seconedLine.add(1);
        res.add(seconedLine);
        if (numRows == 2) {
            return res;
        }
        for (int row = 3; row <= numRows;row++) {
            //上一行
            List<Integer> prevLine = res.get(row - 2);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 1 ; col < row - 1; col++) {
                curLine.add(prevLine.get(col - 1) + prevLine.get(col));
            }
            curLine.add(1);
            res.add(curLine);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        System.out.println(list);
    }
}
