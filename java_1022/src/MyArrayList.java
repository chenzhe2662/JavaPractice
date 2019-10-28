
public class MyArrayList {
    //属性
    private int[] elem;
    private int usedSize;
    private final int CAPACITY = 10;

    public MyArrayList() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    //方法
    // 打印顺序表
    public void display() {
        System.out.print("[");
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i]);
            if (i != usedSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //判断是否满了
    private boolean isFull() {
       /* if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > usedSize) {
            return;
        }
        if (usedSize >= this.elem.length) {
            realloc();
        }
        if (usedSize == pos) {
            this.elem[pos] = data;
            this.usedSize++;
        } else {
            for (int i = usedSize; i > pos; i--) {
                this.elem[i] = this.elem[i - 1];
            }
            this.elem[pos] = data;
            this.usedSize++;
        }
    }

    private void realloc() {
        int[] newElem = new int[this.elem.length * 2];
        for (int i = 0; i < this.elem.length; i++) {
            newElem[i] = this.elem[i];
        }
        this.elem = newElem;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos < usedSize && pos >= 0) {
            return this.elem[pos];
        }
        return -1;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int pos = search(toRemove);
        if (pos == -1) {
            return;
        }
        if (pos == usedSize - 1) {
            this.usedSize--;
            return;
        }
        for (int i = pos; i < usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
}
