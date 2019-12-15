public class HashBuck {
    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    public Node[] array;
    public int usedSize;
//桶初始长度一般16 或 32
    public HashBuck() {
        this.array = new Node[4];
        this.usedSize = 0;
    }

    public void put(int key, int val) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.value = val;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key, val);
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
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    private double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
}
