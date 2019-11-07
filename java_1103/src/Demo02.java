import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("author"));
        System.out.println(map.getOrDefault("author", "noname"));
        System.out.println(map.containsKey("author"));
        System.out.println(map.containsValue("noname"));
        map.put("作者","鲁迅");
        map.put("标题","狂人日记");
        map.put("发表时间","1918年");
//        map.put("author","caoxueqin");
//        map.put("name","hongloumeng");
//        map.put("date","1818年");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("author"));
        System.out.println(map.getOrDefault("author", "noname"));
        System.out.println(map.containsKey("author"));
        System.out.println(map.containsValue("noname"));
        System.out.println("=======================");

        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
