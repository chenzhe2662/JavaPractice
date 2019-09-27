public class SeqList {
    private int[] date = new int[10];
    private int size = 0;

    //打印顺序表
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(this.date[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //在pos新增元素
    public void add(int pos, int n) {
        if (pos < 0 || pos > size) {
            return;
        }
        if (size >= this.date.length) {
            realloc();
        }
        if (size == pos) {
            this.date[pos] = n;
            this.size++;
        } else {
            for (int i = size; i > pos; i--) {
                this.date[i] = this.date[i - 1];
            }
            this.date[pos] = n;
            this.size++;
        }
    }

    private void realloc() {
        int[] newDate = new int[this.date.length * 2];
        for (int i = 0; i < this.date.length; i++) {
            newDate[i] = this.date[i];
        }
        this.date = newDate;
    }

    public boolean contains(int toFind) {
        for (int i = 0; i < this.size; i++) {
            if (toFind == this.date[i]) {
                return true;
            }
        }
        return false;
    }

    public int search(int toFind) {
        for (int i = 0; i < this.size; i++) {
            if (toFind == this.date[i]) {
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {
        if (pos < size && pos >= 0) {
            return this.date[pos];
        }
        return -1;
    }

    public void setPos(int pos, int value) {
        if (pos < size && pos >= 0) {
            this.date[pos] = value;
        }
    }

    public void remove(int toRemove) {
        if (toRemove == this.date[size - 1]) {
            this.size--;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (toRemove == this.date[i]) {
                    this.date[i] = this.date[i + 1];
                }
            }
            this.size--;
        }
    }

    public int size() {

        return this.size;
    }

    public void clear() {
        this.size = 0;
        this.date = new int[10];
    }
}
