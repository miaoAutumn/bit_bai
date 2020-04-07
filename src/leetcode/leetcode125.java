package leetcode;
public class leetcode125 {//验证回文串
        public boolean isPalindrome(String s) {
        //判断是否为空字符串，空字符串总满足回文
      if (s.length()<=1){
        return true;
      }
      int left=0;
      int right=s.length()-1;
       //将字符串转换为字符数组
       char[]chars = s.toCharArray();
      while (left<right){
          //1.整理空格
          if ((int)chars[left]==32){
              left++;
          }
          if ((int)chars[right]==32){
              right--;
          }
          //2.将大写字母转换为小写字母
          //A-Z 65-90 a-z 97-122
          if ((int)chars[left]>=65&&(int)chars[left]<=90){
             chars[left] =(char) ((int) chars[left]+32);
          }
          if ((int)chars[right]>=65&&(int)chars[right]<=90){
              chars[right] =(char) ((int) chars[right]+32);
          }
          //3.验证目标字符为数字或字母
          boolean flag1=(chars[left]>='0'&&chars[left]<='9'
                  ||chars[left]>='a'&&chars[left]<='z');
          boolean flag2=(chars[right]>='0'&&chars[right]<='9'
                  ||chars[right]>='a'&&chars[right]<='z');
          //4.正式比较
          if (flag1&&flag2&&chars[left]!=chars[right]){
              return false;
          }
          else if(!flag1){
              left++;
          }else if (!flag2){
              right--;
          }else if (chars[right]!=chars[left]){
              left++;
              right--;
          }

      }
      return true;
    }
}
