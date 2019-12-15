import java.util.*;
class MyHashSet {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node[] array = new Node[10];
    int usedSize = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {

    }

    public void add(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.val == key) {
                cur.val = key;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if (loadFactor() >= 0.75) {
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node curNext;
            for (Node cur = array[i]; cur != null;
                 cur = curNext) {
                curNext = cur.next;
                int index = cur.val % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    private double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }

    //problem
    public void remove(int key) {
        int index = key % array.length;
        Node node = array[index];
        if (node.val == key) {
            node = node.next;
            return;
        }
        Node cur = node;
        Node prev = node;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = prev.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.remove(1);
        System.out.println(set.contains(1));
    }
}

public class homeWork {
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), count + 1);
            }else {
                map.put(s.charAt(i), count);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 0) {
                return i;
            }
        }
        return -1;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set1.add(nums2[i]);
            }
        }
        int[] arr = new int[set.size()];
        int count = 0;
        for (Integer x : set1) {
            arr[count++] = x;
        }
        return Arrays.copyOf(arr, count);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            }else {
                map.put(num,map.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) - 1);
            }
            if (map.get(num) == 0) {
                map.remove(num);
            }
            list.add(num);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
//    public static void main(String[] args) {
////        String s = "hhllo";
////        System.out.println(firstUniqChar(s));
//        Set<String> set = new HashSet<>() ;
//
//    }
}
