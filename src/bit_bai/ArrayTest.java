package bit_bai;

public class ArrayTest {

    public static void bubbleSort(int [] arr){//1.冒泡排序
        int temp;
        for (int i=0;i<arr.length-1;i++){
            //arr.length-1:防止下标越界；
            // -i：后面i个数字顺序以确定，不需要再判断
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){//升序排列
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
       System.out.println("从小到大排列的结果是");
        for (int i:arr) {
            System.out.println(arr[i]+",");
        }

    }
    public static int binarySearch(int [] arr,int toFind){//2.二分查找
        //待查找区间[left,right];
        int left=0;
        int right=arr.length-1;
        int mid=left+(right-left)/2;//技巧防止溢出
        while (left<=right){//时间复杂度O（logN）;空间复杂度O（1）；
            if(arr[mid]==toFind){
                return mid;
            }
            else if (arr[mid]<toFind){
                left=mid+1;
            }
            else  if (arr[mid]>toFind){
                right=mid-1;
            }
        }
        return -1;

}
    public static void reversr(int [] arr){//3.反转数组
        int temp;
        int len=arr.length;
       for(int i=0;i<len/2;i++){//只需要循环数组长度的一半即可
           temp=arr[i];
           arr[i]=arr[len-1-i];//-i:依次向中间元素靠拢
           arr[len-1-i]=temp;
       }
       System.out.println("反转后的数组是");
        for (int i=0;i<arr.length;i++) {
            System.out.println(","+arr[i]);
        }
    }
}
