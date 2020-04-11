package sort;

import java.util.Arrays;

public class shellSort {
    public static void shellSort(int [] array){
       int gap=array.length/2;
       //gap的常用取值为：size/2,size/4.....1;
      //当gap>1时，都是在预排序，目的是让数组更接近有序
        // 当gap等于1时，数组已经接近有序了，最后再整体排序。
        while (gap>1){
            insertSortGap(array,gap);
            gap=gap/2;
        }
        //循环结束后gap=1，进行最终的排序就ojkl
        insertSortGap(array,1);

    }
    //分组插排，思路和插排一样,间隔为gap
    private static void insertSortGap(int[] array, int gap) {
      for (int bound=gap;bound<array.length;bound++){
          int cur=bound-gap;
          int v=array[bound];
          for (;cur>=0;cur-=gap){
              if (array[cur]>v){
                  array[cur+gap]=array[cur];
              }
              else {
                  break;
              }
          }
          array[cur+gap]=v;
      }
    }
    public static void main(String[] args){
        int [] array={9,6,0,3,1,7,8,4,5};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

}
