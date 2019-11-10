import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("c语言");
        courses.add("JavaSE");
        courses.add("JavaWeb");
        courses.add("c语言");
        System.out.println(courses);
        System.out.println(courses.get(1));
        System.out.println(courses);
        courses.set(0,"计算机基础");
        System.out.println(courses);
        List<String> subCourse = courses.subList(1,3);
        System.out.println(subCourse);
        List<String> courses1 = new ArrayList<>(courses);
        System.out.println(courses1);
        List<String> courses2 = new LinkedList<>(courses);
        System.out.println(courses2);
        ArrayList<String> courses3 = (ArrayList<String>)courses1;
        System.out.println(courses3);
     }
}
