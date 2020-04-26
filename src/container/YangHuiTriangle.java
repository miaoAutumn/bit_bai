package container;

import java.util.ArrayList;
import java.util.List;
    //给定一个非负整数 numRows，生成杨辉三角的前numRows行
//杨辉三角的特点
// 1.第一行,是一个1
// 2.第二行是两个1;
//3.第i行有i个元素,并且首尾两个元素都是1
//4.第i行第j列的元素等于 第 i-1 行第j-1列 + 第i-1行第j列

public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
     List<List<Integer>> result = new ArrayList<>();
     //先对numRows进行合法校验
        if (numRows <= 0){
            //返回size为0的List;
            return result;
        }
        //1.第一行元素是一个1
        List<Integer> firstline = new ArrayList<>();
        firstline.add(1);
        //将第一行加入到整个结果中去,最后结果类似于一个长度不固定的二维数组
        result.add(firstline);
        if (numRows == 1){
            return result;
        }
        //2.第二行元素是两个1;
        List<Integer> secondline = new ArrayList<>();
        secondline.add(1);
        secondline.add(1);
        result.add(secondline);
        if (numRows == 2){
            return result;
        }
        //3.处理第i行元素,
        //要先找到第i行的前一行
        for (int i = 3;i <= numRows;i++) {
            //要想知道第i行的元素值,就得知道第i-1行的元素值
            //因为数组下标都是从0开始的,而第几行第几行是从1开始的
            // 所以i-1求的是第i-1行,i-1-1才能得到第i-1行的下标
         List<Integer> preline = result.get((i-1)-1);
         List<Integer> curline = new ArrayList<>();
         curline.add(1);
         //处理第j列的情况,
        // 因为第i行有i个元素,又因为首末都是1,所以循环次数是i-2次;
         for (int j = 2;j < i;j++){
          //第i行第j列的元素就等于第i-1行第j-1列 + 第i-1行第j列
         //因为第几列第几列都是从1开始,而存在List里面的元素下标都是从0开始,所以要j-1-1;
             int curNum = preline.get(j-1-1) + preline.get(j-1);
             curline.add(curNum);
         }
         //加上最后一个1
         curline.add(1);
         //内部循环结束后 第curline行就整理完毕了
            result.add(curline);
        }
        //外部循环结束后,意味着所有行都整理完毕了
     return result;
    }

    public static void main(String[] args){
        int numRows = 5;
        YangHuiTriangle list = new YangHuiTriangle();
       System.out.println(list.generate(numRows));
    }

}
