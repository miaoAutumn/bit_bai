package sort;

import java.util.Arrays;

public class heapSort {
    public static void heapSort(int[] array) {
        //创建一个大堆
        creatHeap(array);
        //因为比较到最后面就只剩一个元素了，不需要再进行比较，所以是length-1；
        //循环把队顶元素和堆尾元素交换，再删除堆尾元素，再调整堆
        //该元素逻辑上是删除，实际是在数组的末尾
        for (int i = 0; i < array.length - 1; i++) {
            int heapsize=array.length-i;//堆的元素个数
            //因为堆的长度随循环一发生变化，所以每次交换的位置应该是更新后的堆的最后一个元素位置
            //堆的最后一个元素下标就是length-i-1；
            swap(array,0,heapsize-1);
            //再把堆向下调整，重新进入下一次循环
            //交换完成后要把最后一个元素从堆中删除，数组中元素个数为heapsize--；
            heapsize--;
            // 实现删除操作后，传入新的heapsize；
            shiftDown(array,heapsize,0);
        }
    }
    //交换堆顶和堆尾元素
    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;

    }
    //向下调整
     public static void shiftDown(int []array,int size,int index){
        int parent=index;
        int left=parent*2+1;
        while (left<size){
            int right=parent*2+2;
            if (right<size){
                //左右子树都存在的情况下找最大去和父节点进行比较
                if (array[right]>=array[left]){
                    left=right;
                }
            }
            if (array[left]>array[parent]){
                swap(array,left,parent);
            }
            //更新parent的位置
            parent=left;
            left=parent*2+1;
        }
     }

    private static void creatHeap(int[]array) {
        //升序建大堆，降序建小堆
        //向下调整从后往前遍历，向上调整从前往后遍历
        //从最后一个叶子节点的父节点开始
        for (int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    public static void main(String[] args){
        int [] array={2,1,2,0,6,9,5,7};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
