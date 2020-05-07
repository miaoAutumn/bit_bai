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
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        //方法2,将该数组元素放到哈希表中去
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    //219.存在重复元素II,将set当做一个滑动窗口
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            //如果当前set的大小大于k,则将set的前面元素删除,让set始终保持最大k的长度
            //这里是删除对应下标,所以写成for循环更方便后续操作
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    // 389.找不同
    public char findTheDifference1(String s, String t) {
        //1.异或方法
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            m = m ^ s.charAt(i);
            m = m ^ t.charAt(i);
        }
        //因为t始终比s多一个元素,所以要再判断最后多出来的那个元素
        m = m ^ t.charAt(t.length() - 1);
        return (char) m;

    }

    public char findTheDifference2(String s, String t) {
    //2.排序方法
      char [] c1 = s.toCharArray();
      char [] c2 = t.toCharArray();
      Arrays.sort(c1);
      Arrays.sort(c2);
      for (int i = 0;i < s.length();i++){
          if (c1[i] != c2[i]){
              return c2[i];
          }
      }
      return c2[c2.length - 1];
    }

    public char findTheDifference3(String s, String t) {
     //3.差值方法
     char [] c1 = s.toCharArray();
     char [] c2 = t.toCharArray();
     int sums = 0,sumt = 0;
     for (int i = 0;i < s.length();i++){
         sums += c1[i];
     }
     for (int j = 0;j < t.length();j++){
         sumt += c2[j];
     }
     return (char) (sumt - sums);
    }



}
