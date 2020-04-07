package leetcode;

public  class leetcode34 {//在排序数组中查找元素第一个和最后一个的位置
        public int[] searchRange1(int[] nums, int target) { //1.暴力解法，时间复杂度O（N）；
            //初始目标范围
            int [] targetRange={-1,-1};
            //先遍历数组，从前往后找到元素的第一个位置，更新targerRange的左边界，结束循环
            for (int i = 0; i <=nums.length-1 ; i++) {
                if (nums[i]==target){
                    targetRange[0]=i;
                    break;
                }
            }
            //若上方遍历未找到元素，则直接返回[-1.-1]
            if (targetRange[0]==-1){
                return targetRange;
            }
            //再从后往前遍历，找到该元素的倒数第一个值得位置.更新targetRange的右边界，结束循环
            for (int i = nums.length-1; i <=0 ; i--) {
                if (nums[i]==target){
                    targetRange[1]=i;
                    break;
                }
            }
            return targetRange;
        }

}
