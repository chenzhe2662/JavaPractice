import java.util.Collection;

import java.util.ArrayList;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("c语言");
        list.add("Java");
        list.add("python");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] arr =  list.toArray();
        System.out.println(Arrays.toString(arr));
        for (String s : list) {
            System.out.println(s);
        }
        list.remove("Java");
        for(String s : list) {
            System.out.println(s);
        }
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
