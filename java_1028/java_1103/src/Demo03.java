import java.util.HashMap;
import java.util.Map;

public class Demo03 {
    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("作者","鲁迅");
        map.put("标题","狂人日记");
        map.put("发表时间","1918年");
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("author","caoxueqin");
        map.put("name","hongloumeng");
        map.put("date","1818年");
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
