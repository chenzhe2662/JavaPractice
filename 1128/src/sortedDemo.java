import java.util.Arrays;
import java.util.Stack;

public class sortedDemo {
    private static void swap(int[] array , int x ,int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    //插入排序
    //每次将未排序的第一个元素与已排序的所有元素依次向前比较
    //找到比他小的值停下，未找到向前移动
    private static void insertSotr(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
    //希尔排序
    private static void shellSort(int[] array) {
        int[] arr = {5,3,1};
        for (int x : arr) {
            shellSort(array,x);
        }
    }
    private static void shellSort(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            while (j >= 0 && array[j] > tmp) {
                array[j + gap] = array[j];
                j -= gap;
            }
            array[j + gap] = tmp;
        }
    }
    //冒泡排序
    //每次将未排序的最大元素找到放在未排序的最前
    //优化：每次交换的时候设立一个flag ，如果不交换了说明已经有序跳出
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array,j,j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    //选择排序
    //依次往后找到比未排序第一个元素小的值然后交换
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array,i,j);
                }
            }
        }
    }
    //堆排序
    //创建大根堆
    //将根节点与未排序的最后一个元素交换
    //再次向下调整找到最大根节点。
    private static void heapSort(int[] array){
        createHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array,0,array.length - i - 1);
            shitdown(array,0,array.length - i - 1);
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shitdown(array,i,array.length );
        }
    }
    private static void shitdown(int[] array, int root, int size) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size &&
                            array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }
    //快速排序
    public static void quickSort(int[] array) {
        quickSort(array,0,array.length - 1);
    }
    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = partition(array,low,high);
        quickSort(array,low,index - 1);
        quickSort(array,index + 1,high);
    }
    //设立基准值
    private static int partition(int[] array, int low, int high) {
        int base = array[high];
        int index = high;
        while (low < high) {
            while (low < high && array[low] <= base) {
                low++;
            }
            while (low < high && array[high] >= base) {
                high--;
            }
            swap(array,low,high);
        }
        //一定是low 与 原来的基准值交换 也就是 找完的最后一个值
        //一定是大于基准值的才能和基准值的位置交换。
        swap(array,low,index);
        return low;
    }
    //快速排序(非递归)
    private static void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int low = stack.pop();
            int high = stack.pop();
            if (low >= high) {
               continue;
            }
            int index = partition(array,low,high);
            stack.push(index - 1);
            stack.push(low);
            stack.push(high);
            stack.push(index + 1);
        }
    }
    //归并排序
    private static void mergeSort(int[] array,int low,int high) {
        if (low == high ) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array,low,mid);
        mergeSort(array,mid + 1,high);
        merge(array,low,mid,high);
    }
    public static void merge(int[] array,
                             int low, int mid,int high){
        int s1 = low ;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] tmp = new int[len];
        int i = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            }else {
                tmp[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[i++] = array[s2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            array[low + j] = tmp[j];
        }
    }
    //归并排序(非递归)
    private static void mergeSort1(int[] array) {
        for (int i = 1; i < array.length; i *= 2) {
            merge1(array,i);
        }
    }
    private static void merge1(int[] array,int gap) {
        int[] tmp = new int[array.length];
        int k = 0;

        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 >= array.length ?
                     array.length - 1 : s2 + gap - 1;
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmp[k++] = array[s1++];
                }else {
                    tmp[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[k++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[k++] = array[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 >= array.length ?
                           array.length - 1 : s2 + gap - 1;
        }
        while (s1 <= array.length -1) {
            tmp[k++] = array[s1++];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {5,9,2,7,6,8,1,3} ;
        //insertSotr(array);
        //shellSort(array);
        //bubbleSort(array);
        //selectSort(array);
        //heapSort(array);
        //quickSort1(array);
        //mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
