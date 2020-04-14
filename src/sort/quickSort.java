package sort;
import java.util.Arrays;
import java.util.Stack;

public class quickSort {
    public static void quickSort(int[] array){
        //辅助完成递归过程
        //为了代码简单，将区间设置为前闭后闭
        quickSortHelper(array,0,array.length-1);

    }
   //递归比较三部分
    private static void quickSortHelper(int[] array,int left,int right){
        if(left>=right){
            //区间最多只有一个元素,不需要排序
            return;
        }
        //对[left，right]区间进行比较操作，使用辅助方法
        //进行比较交换操作，并记录更新后的基准值
       int index = partition(array,left,right);
        //递归比较基准值的左边和基准值的右边
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);

    }
   //进行比较交换操作
    private static int partition(int[] array, int left, int right) {
        //这里需要将下标备份一份用于后期的交换操作，所以不能直接用left和right
        int i=left;
        int j=right;
        //基准值，取最后一位为基准值
        int bound = array[j];
        //先从左往右遍历，再从右往左遍历，
        //将小的值放在前面，大的值放在后面，当left与right重合时，更新基准值位置
        while (i<j){
            while (i<j&&array[i]<=bound){
                //是要从左往右找大于基准值的数。所以当里的值小于等于基准值时，就略过
                i++;
            }
            while (i<j&&array[j]>=bound){
                //j是要从右往左找小于基准值的数。所以当里的值大于等于基准值时，就略过
                j--;
            }
            //内部两个循环结束时，代表找到大于基准值的数，找到了小于基准值的数，交换这两个值
            swap(array,i,j);
        }
        //外部循环结束时，说明与重合了，则要更新基准值,交换i与基准值的位置rigth;
        swap(array,i,right);
        return i;
    }
    //交换元素
    private static void swap(int[] array, int left, int right) {
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }


    public static void  quickSortByLoop(int [] array){
        //借助栈，进行快排的非递归实现
        Stack<Integer> stack = new Stack<>();
        //栈里面用来存数组下标。通过下标来表示要处理的区间。
        //先把右侧下标入栈，再把左侧下标入栈 [0,array.length-1]
        stack.push(array.length-1);
        stack.push(0);

        while (!stack.isEmpty()){
            //先把左侧下标出栈，再把右侧下标出栈
            int left = stack.pop();
            int right = stack.pop();
            if (left>=right){
                //说明区间中最多只有一个元素，不需要排序
                continue;
            }
            //调用partition方法将区间整理为左侧小于等于基准值右侧大于等于基准值的情况并且要更新基准值
            int index = partition(array,left,right);
            //准备处理下一个区间
            //更新区间,现将左侧区间入栈[left,index-1]
            stack.push(index-1);
            stack.push(left);
            //再将右侧区间入栈[index+1,right]
            stack.push(right);
            stack.push(index+1);
        }

    }
    public static void main(String[] args){
        int []array = {9,4,7,2,5,0,3,6,7,1,8};
//        quickSort(array);
        quickSortByLoop(array);

        System.out.println(Arrays.toString(array));
    }

}
