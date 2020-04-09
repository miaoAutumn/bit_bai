package container;

public class MyPriorityQueue {

    //优先级队列，使用堆来构建
    //用来演示，暂不考虑扩容情况
    int [] array = new int[100];
    int size=0;//有效元素个数
    //array看似是一个数组，其实是一个堆结构
    //入队列，用尾插方式入对列，然后通过向上调整将队列调整为堆结构。
    public void offer(int x){
    //将x尾插进数组
        array[size]=x;
        size++;
    //把尾插的元素进行向上调整,size-1就是当前尾插的新元素的位置
      shiftUp(array,size-1);
    }
    //向上调整,大堆
    private void shiftUp(int[] array, int index) {
        int parent=(index-1)/2;
        while (index>0){
            //如果当前元素大于parent，不符合大堆要求，则交换
            if (array[index]>array[parent]){
                int temp=array[parent];
                array[parent]=array[index];
                array[index]=temp;

            }
            else {//当发现夫节点比子结点大时，说明所有节点都调整完毕，已经是一个大堆了
                break;
            }
            //更新位置
            index=parent;
            parent=(index-1)/2;
        }
    }

    //出队列，把下标为0也就是队首元素出队列删除的同时，也希望剩下的结构依然是一个堆结构，
    // 所以方法就是将下标为0的元素和最末元素交换位置，然后尾删（size--）,再进行向下调整操作
    public int poll(){
        int oldvalue=array[0];
        array[0]=array[size-1];
        size--;
        //把更新后的0号位置整下去
     shiftDown(array,size,0);
        return oldvalue;
    }
    //向下调整，恢复堆结构,大堆
    public static void shiftDown(int array[] ,int size,int index ){
        int left=index*2+1;
        int max=left;
        while (left<size){
            int right=index*2+2;
            if (right<size){
                if (array[right]>array[left]){
                    max=right;
                }
            }
            if (array[index]>=array[max]){
                break;
            }
            else {
                int temp = array[index];
                array[index] = array[max];
                array[max] = temp;
            }
            index=left;
            left=index*2+1;
        }
    }

    //取队顶
    public int peek(){
        return array[0];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public static void main(String[] args){
        MyPriorityQueue queue=new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);

        //优先级打印
        //每poll一个元素就相当于把优先级最高或最低的元素取出来，
        // 若pollN次，就相当于对数组进行了排序，这就是堆排序
        while (!queue.isEmpty()){
            int cur=queue.poll();
            System.out.print(cur+" ");
        }
    }


}
