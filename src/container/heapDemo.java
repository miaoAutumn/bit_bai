package container;
public class heapDemo {
    //堆的向下调整,以小堆为例
    //size是array哪些元素是有效的堆元素
    //index是从哪个位置的下标开始调整，也就是当前的根节点
    public static void shifDown(int[] array,int size,int index){
        int left=index*2+1;
        while (left<size) {//说明左子树是存在的
            int right = index * 2 + 2;
            int min = left;
            if (right < size) {//如果右子树也存在
                if (array[right] < array[left]) {//找到左右子树中较小值的下标，记录近min中去，
                    min = right;
                }
            }
            //右子树不存在,只用比较当前值和最小值即可
            if (array[index] <= array[min]) {
                break;
            }
            //交换当前值和左右子树中的最小值，保证根节点的值小于左右子树
            else {
                int temp = array[index];
                array[index] = array[min];
                array[min] = temp;
                //更新当前位置，继续向下调整
                index = min;
                left = index * 2 + 1;
            }
        }

        }
     //建堆时，从前往后遍历：向上调整
    //从后往前遍历：向下调整，从最后一个叶子节点的父节点开始遍历
    //size-1，是最后一个叶子节点的位置，再-1/2,得到该叶子节点的父节点
     // 如果是size-1的话，逻辑无影响，循环会多空转几回
        public  static void createHeap(int[] array,int size){
        for (int i=(size-1-1)/2;i>=0;i--){
            shifDown(array,size,i);
        }
        }
    }

