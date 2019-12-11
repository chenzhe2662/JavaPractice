import java.util.Arrays;
import java.util.Stack;

public class Sorted {
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp ) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
    private static void shell(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            while (j >= 0 && array[j] > tmp ) {
                array[j + gap] = array[j];
                j -= gap;
            }
            array[j + gap] = tmp;
        }
    }
    private static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int aDrr : drr) {
            shell(array, aDrr);
        }
    }
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }

        }
    }
    private static void heapSort(int[] array) {
        createHeap(array);
        for (int i = 0; i < array.length; i++) {
            int tmp = array[0];
            array[0] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
            shiftDown(array, 0,array.length - i - 1);

        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 2) / 2;i >= 0 ; i--) {
            shiftDown(array,i,array.length);
        }
    }
    private static void shiftDown(int[] array, int root,int size) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size &&
                                array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else  {
                break;
            }
        }
    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length;i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1 ;j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length - 1);
    }
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right ) {
            return;
        }
        int index = partition(array,left,right);
        quickSort(array,left,index - 1);
        quickSort(array,index + 1,right);

    }
    private static int partition(int[] array, int left ,int right ) {
        int v = array[right];
        int index = right;
        while (left < right) {
            while (left < right && array[left] <= v) {
                left++;
            }
            while (left < right && array[right] >= v) {
                right--;
            }
            swap(array,left,right);
        }
        swap(array,left,index);
        return left;
    }
    private static void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right ) {
                continue;
            }
            int index = partition(array,left,right);
            stack.push(index - 1);
            stack.push(left);
            stack.push(right);
            stack.push(index + 1);
        }
    }
    private  static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static void mergeSort(int[] array) {
        mergeSort(array,0,array.length);
    }
    private static void mergeSort(int[] array,int left ,int right) {
        if (left >= right || right - left == 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array,left,mid);
        mergeSort(array,mid,right);
        merge(array,left,mid,right);
    }
    private static void merge(int[] array,int left,int mid,int right) {
        int len = right - left;
        int[] out = new int[len];
        int index = 0;
        int i = left;
        int j = mid;
        while (i < mid && j < right) {
            if (array[i] <= array[j]) {
                out[index++] = array[i++];
            }else  {
                out[index ++] = array[j++];
            }
        }
        while (i < mid) {
            out[index++] = array[i++];
        }
        while (j < right) {
            out[index++] = array[j++];
        }
        for (int k = 0;k < array.length;i++) {
            array[left + k] = out[k];
        }
    }
    public static void main(String[] args) {
        int[] array = {13,8,2,7,10,11,1,5,9,7,18,6,25,30,21};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
       // quickSort1(array);
        mergeSort(array);
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void merge1(int[] array,int gap) {
        int[] tmp = new int[array.length];
        int i = 0;

        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 >=
                array.length ? array.length-1 : s2+gap-1;

        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                //
                if (array[s1] <= array[s2]) {
                    tmp[i++] = array[s1++];
                }else {
                    tmp[i++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[i++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[i++] = array[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2+gap-1 >=
                    array.length ? array.length-1 : s2+gap-1;
        }

        //判断s1是否有数据
       while (s1 <= array.length - 1) {
           tmp[i++] = array[s1++];
       }

        //拷贝tmp到array
        for (int j = 0 ; j < array.length ; j++) {
            array[j] = tmp[j];
        }

    }
    public static void mergeSort1(int[] array) {
        for (int gap = 1; gap < array.length; gap*=2) {
            merge1(array,gap);
        }
    }
}
