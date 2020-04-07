package bit_bai;
import java.util.Arrays;
public class Leetcode {
}
class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
class Solutio2 {//判断回文
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}

class Solution3 {//查找最后一个单词的长度
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        while (i>=0&&s.charAt(i)==' '){
            i--;
        }
        if(i<0){
            return 0;
        }
        int j=i;
        while (j>=0&&s.charAt(j)!=' ') {
            j--;
        }
        return i-j;


    }
}

class Solution4 {//合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1=m-1;
        int len2=n-1;
        int len= nums1.length-1;
        while (len1>=0&&len2>=0){
            if(nums1[len1]>nums2[len2]){
                nums1[len]=nums1[len1];
                len1--;
                len--;
            }
            else{
                nums1[len]=nums2[len2];
                len--;
                len2--;
            }
        }
        System.arraycopy(nums2,0,nums1,0,len2+1);


    }
}class Solution5 {
    public boolean containsDuplicate(int[] nums) {
        int[] nums2;
        System.arraycopy(nums,0,nums,0,nums.length);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

class Solution6 {//长按键入
    public boolean isLongPressedName(String name, String typed) {
        char[] c1=name.toCharArray();
        char[] c2=typed.toCharArray();
        int i=0;
        int j=0;
        while (i<c1.length&&j<c2.length){
            if (c1[i]==c2[j]){
                i++;
            }
            j++;
        }
        return i==c1.length;

    }
}
class Solution7 {//有序数组的平方
    public int[] sortedSquares(int[] A) {
        int [] result=new int[A.length];
        int light=A.length-1;
        int left=0;
        int right=A.length-1;
        while (left<=right){
            if(A[left]*A[left]>=A[right]*A[right]){
                result[light]=A[left]*A[left];
                left++;
            }
            else {
                result[light]=A[right]*A[right];
                right--;

            }
            light--;
        }
        return result;



    }
}
class Solution8 {//仅反转字母
    public String reverseOnlyLetters(String S) {
        if (S==null&&S.length()==0){
            return " ";
        }
        char array [] =S.toCharArray();
        int left=0;
        int right=S.length()-1;
        char temp;
        while (left<=right){
            while(!Character.isLetter(array[left])){
                left++;
            }
            while (!Character.isLetter(array[right])){
                right--;
            }
            temp=array[right];
            array[right]=array[left];
            array[left] = temp;
            left++;
            right--;
        }
        return new String(array);



    }
}
class Solution9 {//按奇偶排列数组
    public int[] sortArrayByParity(int[] A) {
        int[] array=new int [A.length];
        int left=0;
        int right=A.length-1;
        for (int i=0;i<A.length;i++) {
            if(A[i]%2==0){
                array[left]=A[i];
                left++;
            }
            else {
                array[right] = A[i];
                right--;
            }
        }
        return array;
    }

}
class Solution10 {//寻找数组的中心索引
    public int pivotIndex(int[] nums) {
        int sum=0;
        int sum2=0;
        int i;
        if (nums.length<0){
            return -1;
        }
        for (i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for (i=0;i<nums.length;i++){
            if (sum==sum2*2+nums[i]){
                return i;
            }
            sum2+=nums[i];
        }
        return -1;
    }
}
class Solution11 {//加一
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if (digits[i]!=0){//说明无进位
                return digits;
            }
        }
        digits=new int [digits.length];
        digits[0]=1;
        return digits;

    }
}
class Solution12 {//两数之和，暴力解法
    public int[] twoSum(int[] nums, int target) {
        int i;
        int j;
        int [] res=new int[2];
        for (i=0;i<nums.length;i++){
            for(j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }
}


