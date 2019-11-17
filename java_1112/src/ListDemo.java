import java.util.ArrayList;
import java.util.List;
class Student {
    String name;
    String classes;
    double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
    public int  compareTo (Student s) {
        return (int) (this.score - s.score);
    }
}
public class ListDemo {
    public static void main(String[] args) {
        List<Student>  list= new ArrayList<>();
        list.add(new Student("张三","一班",85.5));
        list.add(new Student("李四","一班",95.5));
        list.add(new Student("王二","一班",70.5));
        list.add(new Student("麻子","一班",89.5));
        list.sort(Student::compareTo);
        for (Student s : list) {
            System.out.println(s);
        }


    }
}
