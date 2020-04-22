package homeworks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class List1 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    //员工的重要性
    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            //1.当员工id与输入id相同时，将此员工的重要性入队列，再出队列，记录其重要性
            //2.再将当前员工的下属员工的重要性依次入队列，再出队列，将重要性累加求和
            Queue<Integer> queue = new LinkedList<>();
            if (employees == null){
                return 0;
            }
            int result = 0;
            queue.offer(id);
            while (!queue.isEmpty()){
                int temp = queue.poll();//temp里面存的就是当前id值
                //遍历员工list找到某个员工的id与当前temp值相同即为所求员工
                //内部循环是将下属入队列出队列操作
                //外部循环是累加重要性
                for (Employee e:employees){
                    if (e.id == temp ) {
                        //说明所求员工就是他，将他的重要性相加起来
                        result += e.importance;

                        //再依次将他的下属员工入队列，再出队列，累加重要性
                        for (Integer i : e.subordinates) {
                            if (i == null) {
                                //代表没有下属了，循环也就结束了
                                return result;
                            }
                            queue.offer(i);

                        }
                    }
                }
                }
                return result;
            }
        }


        //找到小镇的法官
       //基于投票思想，若N个人投票都投给法官，则法官最终得票为N-1票。
        public int findJudge(int N, int[][] trust) {
        //int型数组默认值是0；
        int [] cur = new int[N+1];//N个人都有被投票和投票的可能性,0不算
            for (int [] index :trust){
                //一维trust里面存两个值，第一个是投票者，第二个是被投票者也就是法官候选人
                cur[index[0]]--;//投票者投票后将票数-1；
                cur[index[1]]++;//候选人得票后将票数+1；
            }
            //上循环结束后代表大家都投票了，此时法官手中得票一定是N-1票
            for ( int i = 1; i <= N; i++ ) {
                if ( cur[i] == N-1 ){
                    return i;
                }
            }
            return -1;
        }


        //将数组分成和相等的三个部分
        public boolean canThreePartsEqualSum(int[] A) {
         //1.分成和相等的三个部分则意味着和一定是3的倍数，如果不是直接返回false
            int sum = 0;
            for (int i = 0;i<A.length;i++){
               sum += A [i];
            }
            if (sum%3 != 0){
                return false;
            }
        //2.使用双指针分别从头尾出发，加快速率
            int left = 0;
            int right = A.length-1;
            int leftsum = A[left];
            int rightsum =A[right];
            //循环将A中元素按左右指针分别求和
            //将left+1<right作为循环条件，若是left<right的，则不能保证一定是将数组分为3部分
            //如：[1，-1,1，-1]
            while (left+1<right){
                if (leftsum != sum/3){
                    //左边不等于1/3，则更新left的值和左边sum的值
                    left++;
                    leftsum += A[left];
                }
                if (rightsum != sum/3){
                    //右边不等于1/3，则更新right的值和右边sum的值
                    right--;
                    rightsum += A[right];
                }
                //此时代表sum已经被分为和相等的三部分（中间部分肯定也为1/3）
                if (rightsum == sum/3&&leftsum == sum/3){
                    return true;
                }
            }
            //循环结束还没找到left和right合适的位置则代表不能平均分
            return false;

            }
            //将数组分成和相等的三个部分,方法2
        public boolean canThreePartsEqualSum2(int[] A) {
        int sum = 0;
        for(int i: A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }
        int s = 0;
        int flag = 0;//记录是前中后哪个部分
        for(int i:A){
            s += i;
            if(s == sum/3){
                //当sum的值累加到sum/3时,代表此时前段已经找到了
                //更新flag,开始记录中段
                flag++;
                s = 0;
            }
        }
        //当flag>3时,一定是后段的后面元素相加为0,所以不用考虑
        // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
        return flag >= 3;
    }
}





