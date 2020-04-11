package sort;

import java.util.Arrays;

public class insertSort {
    //插入排序，默认升序
    public static void insertSort(int [] array){
        for (int bound=1;bound<array.length;bound++){
            //[1,bound):已排序区间
            //[bound，size）：未排序区间
            int v=array[bound];//将bound位置的元素先备份一份,
                              // 这是未排序区间的第一个元素
            //cur保存已排序区间的最后一个元素
            int cur= bound-1;
            //将bound在已排序区间中找到合适的位置插入,从后往前查找
            for (;cur>=0;cur--){
                //要去跟v比较，不要跟array[bound]比较，因为bound的值下次就变了
                if (v < array[cur]){
                    //若cur的值大，则将cur向后调整
                    array[cur+1]=array[cur];
                }
                else {  //若v的值大，则不动
                   break;
                }
            }
            //将备份的bound-1的值，向前调整，因为cur--了，所以此处cur+1
            array[cur+1]=v;
        }
    }
    public static void main(String[] args){
        int[] array={9,5,6,0,4,2,7,3,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
