package Students;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("张三",95),
                new Student("李四",99),
                new Student("王二",85),
                new Student("麻子",96)
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

    }
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    Comparable tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
    }
}
class  Student implements Comparable{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        if( score > s.score){
            return -1;
        } else  if(score < s.score){
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString () {
        return "[" + name + ":" + score + "]";
    }

}
