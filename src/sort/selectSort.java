package sort;

import java.util.Arrays;
public class selectSort {
    //直接选择排序，基于打擂台思想,默认升序
    public static void selectSort(int [] array){
        for (int bound=0;bound<array.length;bound++){
            //外部循环使用bound，区分有序区间和无序区间
            //将bound的值作为擂主，循环取出剩余元素进行与bound中元素进行比较打擂
            for (int cur = bound+1;cur<array.length;cur++){
                if (array[bound]>array[cur]){
                    //默认是升序，当擂主大于后面元素时，打擂成功，则交换两者位置。
                    int temp = array[bound];
                    array[bound] = array[cur];
                    array[cur] = temp;
                }
                //当擂主小于后面元素时，则继续遍历下一个元素，cur++即可
            }
        }
    }
    public static void main(String[] args){
        int []array = {9,5,7,0,3,1,6,8};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
