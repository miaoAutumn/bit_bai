package container;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashCodeInterview {


    //存在重复元素
    public boolean containsDuplicate1(int[] nums) {
    //方法1,对该数组进行排序,排序后形同元素应该相邻
    //理论上不应该直接在原数组上进行排序修改,应该拷贝副本
       Arrays.sort(nums);
     for (int i = 0;i<nums.length-1;i++){
         if (nums[i] == nums[i + 1]){
             return true;
         }
     }
     return false;
    }
    public boolean containsDuplicate2(int[] nums) {
    //方法2,将该数组元素放到哈希表中去
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i:nums){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }

   //219.存在重复元素II,将set当做一个滑动窗口
     public boolean containsNearbyDuplicate(int[] nums, int k) {
     Set<Integer> set = new HashSet<>();
         for (int i = 0;i< nums.length;i++) {
             if (set.contains(nums[i])){
                 return true;
             }
             else {
                 set.add(nums[i]);
             }
             //如果当前set的大小大于k,则将set的前面元素删除,让set始终保持最大k的长度
             //这里是删除对应下标,所以写成for循环更方便后续操作
             if (set.size() > k){
                 set.remove(nums[i-k]);
             }
         }
         return false;
    }

}
