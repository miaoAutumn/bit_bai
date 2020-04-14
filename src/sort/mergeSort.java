package sort;

import java.util.Arrays;

public class mergeSort {
    //归并排序
    //h核心思想是合并两个有序数组
    public static void mergeSort(int []array){
        //为了代码简单，将区间设置为前闭后开
        mergeSorthelper(array,0,array.length);
    }


    //借助辅助方法实现递归多区间排序
    private static void mergeSorthelper(int[] array,int low,int hight) {
        //此时是一个前闭后开区间[low，hight）
        // 当她两差值<=1时，代表该区间最多只有一个元素，不需要排序，作为递归结束的条件
        if (hight-low<=1){
            return;
        }
        //将整个区间均分为两份，[low,mid),[mid,hight)
        int mid=(low+hight)/2;
        //递归操作每个被区分的小区间，直到区间中最多只有一个元素，递归结束
        //这个方法递归完，表示[low,mid)以排序完
        mergeSorthelper(array,low,mid);
        //这个方法递归完，表示[mid,hight)以排序完
        mergeSorthelper(array,mid,hight);
        //当每个小区间都有序时，接下来进行合并有序区间操作，传两个区间过去
        merge(array,low,mid,hight);
    }


     //进行合并有序区间操作,两个有序区间就是[low,mid),[mid,hight)
    private static void merge(int[] array, int low, int mid, int hight) {
        //先将下标备份记录下来
        int i=low;
        int j=mid;
        //开辟一个新数组用来存放临时比较操作
        int [] temp=new int[hight-low];
        int k=0;//k表示新数组下标
        //同时从两个区间的头部（low，mid）出发，谁小就先存放到新数组中去，
        // 若一区间以全部比较完，就将另一个区间的值全部尾插进新数组
        while (i<mid&&j<hight){
            //这里的<=是为了保证稳定性
            if (array[i]<=array[j]){
                temp[k]=array[i];
                //更新i，k，往前走
                i++;
                k++;
            }
            else {
                temp[k]=array[j];
                k++;
                j++;

            }
        }
        //上述循环结束，则一定代表i走到尽头，或者j走到尽头，此时将另一个区间剩下的元素入新数组即可
        //因为区间内本身是有序数组，所以直接入新数组不会有问题
        while (i<mid){
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j<hight){
            temp[k] = array[j];
            j++;
            k++;
        }
        //此时新数组中就是一组已经合并了的有序数组，将新数组循环遍历搬运至旧数组
        for (int p = 0;p < hight-low;p++){
          array[low+p]=temp[p];
        }
    }

    public static void mergeSortByLoop(int[] array){
        for (int i=1;i<array.length;i=i*2){//引入一个i变量进行分组
            //下面的循环执行一次就完成了一次相邻两个组的合并
            for (int j = 0;j<array.length;j=j+2*i){
                int beg=j;
                int mid=j+i;
                int end=j+2*i;
                if (mid>array.length){
                    mid=array.length;
                }
                if (end>array.length){
                    end=array.length;
                }
                merge(array,beg,mid,end);
            }

        }

    }
    public static void main(String[] args){
        int [] array={9,3,8,1,0,0,5,9,2,6};
//        mergeSort(array);
        mergeSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
