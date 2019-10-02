public class SeqList {
    private int[] data = new int[10];
    private int size = 0;

    //打印顺序表
    public void display() {
        System.out.print("[");
        for(int i=0;i<this.size;i++){
            System.out.print(this.data[i]);
            if(i!=this.size-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //在pos新增元素
    public void add(int pos, int elem) {
       if(pos<0||pos>=this.size){
           return;
       }
       if(this.size>=this.data.length){
           realloc();
       }
       if(pos==this.size){
           this.size++;
           this.data[pos]=elem;
       }else{
           for(int i= this.size;i>pos;i--){
               this.data[i]=this.data[i-1];
           }
           this.data[pos]=elem;
           this.size++;
       }
    }

    private void realloc() {
        int[] newData= new int[this.data.length*2];
        for(int i= 0;i<this.data.length;i++){
            newData[i]=this.data[i];
        }
        this.data=newData;
    }

    public boolean contains(int toFind) {
        for(int i=0;i<this.size;i++){
            if(toFind==this.data[i]){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind) {
        for(int i=0;i<this.size;i++){
            if(toFind==this.data[i]){
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {
        if(search(pos)!=1){
            return this.data[pos];
        }
        return -1;
    }

    public void setPos(int pos, int value) {
        if(search(pos)!=1){
            this.data[pos]=value;
        }
    }

    public void remove(int toRemove) {
        if(search(toRemove)==-1){
            return;
        }
        if(search(toRemove)==this.size-1){
            this.size--;
        }
        for(int i=0;i<this.size-1;i++){
            if(toRemove==this.data[i]){
                this.data[i]=this.data[i+1];
            }
        }
        this.size--;
    }

    public int size() {

        return this.size;
    }

    public void clear() {
        this.size=0;
    }
}
