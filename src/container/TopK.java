package container;


import java.util.*;


class Pair implements Comparable<Pair>{
    public int n1;
    public int n2;
    public int sum=n1+n2;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1+n2;
        }

    @Override
    //用comparaTo接口实现对pair里数对的排序，也就是实现小堆操作
    public int compareTo(Pair o){
      //如果this比other大，就返回>0
      // 如果this比other小，就返回<0
       //如果this比other大，就返回=0
        //此处直接用sum值来衡量pair的大小
        return this.sum-o.sum;
    }
}
public class TopK {
    //返回值形如二维数组，一行就是一对数，总共有k行
    // [
    // [num1,num2]
    // [num1,num2]
    // ]
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> result=new ArrayList<>();
    //先对不合法情况进行校验
        if (nums1==null||nums2==null||k<=0){
            return result;
        }
        //采用第一种思路，将所有数对放置队列中，将队列调整为一个小堆，再循环取出k个队首元素
        //调用标准库中的优先级队列
        PriorityQueue<Pair> queue=new PriorityQueue<>();
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                queue.offer(new Pair(nums1[i],nums2[j]));
            }
        }
        //循环结束后，此时所有的数对都在队列中，此时循环k次取出队首元素,加入result即为所求
        //注意：这里要考虑若queue的size小于k值，则输出所有元素，对应示例3，记得考虑
        for (int i=0;i<k&&!queue.isEmpty();i++){//注意是i<k,不是i<=k
            Pair cur=queue.poll();//poll出来的值是数对
            List<Integer> temp=new ArrayList<>();
            temp.add(cur.n1);//把这些数值对先加到一维数组里面
            temp.add(cur.n2);
            result.add(temp);//再将一维数组加到二维数组里面
        }
      return result;
    }
}
