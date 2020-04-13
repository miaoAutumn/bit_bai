package sort;

import java.util.Arrays;

public class bubbleSort {
    public static void bubbleSort(int []array){
        //冒泡排序的思想：在无序区间里比较相邻两个元素，按照一定的顺序进行交换，持续这个过程直到数组有序
        for (int bound=0;bound<array.length-1;bound++){
            //默认升序的话，找最小，从后往前遍历
            //cur>bound为止，因为跑bound趟后，bound前面的元素已经排好序了，不需要再比较
            for (int cur=array.length-1;cur>bound;cur--){
                //比较相邻两个元素的大小关系
                //此处条件写成>=则无法保证有序
                if (array[cur-1]>array[cur]){
                    int temp=array[cur];
                    array[cur]=array[cur-1];
                    array[cur-1]=temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[]array={9,7,1,6,0,3,5,3,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
