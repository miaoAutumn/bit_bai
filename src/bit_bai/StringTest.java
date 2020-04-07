package bit_bai;

public class StringTest {
    public static void main(String[] args){
        //最常用的创建字符串方法
//        String string="hello";
//        String string2=new String("hello");
//        String string4=new String();
//        char [] array={'a','b','c'};
//        String string3=new String(array);
////        System.out.println(string.equals(string2));
//        //String类里包含的各种方法
//   //1.字符与字符串的相互转换
//        System.out.println(new String(array,1,1));
////        System.out.println(string.charAt(0));
////        System.out.println(string.toCharArray());
        //给定一个字符串判断其是否全部是由数字组成的
//        String string="12b39";
//        String string2="helloworld";
////        System.out.println(isnumbers(string)?"是全部由数字组成的":"不是全部由数字组成的");

        //2.字节与字符串的相互转换
        //若按文本处理，一般按照字符数组处理
        //若按二进制存储或者网络传输，则按字节处理
//        byte[] data=string2.getBytes();//将字符串变成字节数组
//        for (int i = 0; i <data.length ; i++) {
//            System.out.println("字节数组是"+data[i]+" ");
//        }
//        System.out.println("字符串是"+new String(data));
//
      //3.字符串相互之间的比较
        String string1="Hello";
        String string3="hELLO";
        System.out.println(string1.equals(string3));//区分大小写的比较，false
        System.out.println(string1.equalsIgnoreCase(string3));//不区分大小写的比较，true
        //comparaTo（）方法，先比较第一个字符的大小，再依次比较后面字符的大小
        // 相等：返回0；小于返回小于0的值；大于则返回大于零的值
        System.out.println(string1.compareTo(string3));//-32,1>2
      //4.字符串查找
        //a.从一个完整字符串中判断指定内容是否存在，最好用方便的是contains（）方法
        String string="helloworld";
        System.out.println(string.contains("llw"));//false,必须是相同字符串
        System.out.println(string.contains("llo"));//true
//        b.使用index（）方法进行位置查找
         System.out.println(string.indexOf("world"));//找到则返回开始位置的索引
         System.out.println(string.indexOf("xxx"));//未找到返回-1
         System.out.println(string.indexOf("ll",1));
         System.out.println(string.lastIndexOf("l"));
         //c.判断开头或结尾
       String string2="##**8h6rh90";
       System.out.println(string2.startsWith("##"));
       System.out.println(string2.startsWith("**",3));
       System.out.println( string2.endsWith("0"));
      //5.字符串替换 ，并没有改变原来字符串的值，而是根据规则，生成一个替换后的新的字符串
//        String string3="helloworld";
//        System.out.println(string3.replaceAll("l","r"));//替换所有l为r
//        System.out.println(string3.replaceFirst("l","w"));//替换第一个l为w
     // 6.字符串拆分
        String string4="hello world hello bit";
        //String [] str=string4.split(" ");//按照空格拆分
        String [] str=string4.split(" ",3);//按照空格拆分,拆封成最多3个字符串
        for (String i:str){//foreach语句，输出下标就可以了
            System.out.println(i);
        }
        //在String。split默认是不合并拆分符的，相邻两个分隔符会算成两个分隔符
        //在正则表达式中，有的特殊的字符串作为分隔符可能无法正确分割，所以需要加上转义
        //字符"|","+","*",都需要加上转义字符"\"；
        //如果是""，则需要加上"\\";
        //多次拆分，以后常用
        String string5="name=b&number=526&age=18";
        String [] str2=string5.split("&");//进行多次拆分的时候，需要在已拆分后的字符串组里再进行拆分
        for (int i=0;i<str2.length;i++) {
            String [] str3=str2[i].split("=");
            System.out.println(str3[0]+"="+str3[1]);
        }
        String string6="name=bai&number=526&age=18";
        String [] str3=string5.split("&");
        for (int i=0;i<str3.length;i++) {
            System.out.println(str3[i]);//结果相同
        }
        //7.字符串截取 从一个完整字符串中截取部分内容
        String string7="helloeorld";
        System.out.println(string7.substring(5));//从指定位置5到结尾
        System.out.println(string7.substring(2,5));//截取部分内容，[2，5）；包含2，不包含5
        //8.    去点字符串中左右空格，保留中间空格
        String string8=" hello world hello  ";
        System.out.println("["+string8.trim()+"]");
        //9.判断字符串是否为空字符串，但不是null，而是长度为0；
        System.out.println(string8.isEmpty());
        System.out.println("".isEmpty());//空字符串
        System.out.println(new String().isEmpty());//有对象但是未赋值，是空字符串
        //10.首字母大写，String中没有让首字母大写的方法，可以自己实现
        System.out.println(firstupper("message"));
        System.out.println(firstupper("d"));
        System.out.println(firstupper(" "));
    }
    public static String firstupper(String string9){
        String string10="";
        if ("".equals(string9)||string9==null){//考虑特殊情况，字符串0个元素或为null
            return string9;
        }
        if (string9.length()>=1){//字符串有最少一个有效元素
           string10=string9.substring(0,1).toUpperCase()+string9.substring(1);
        }
        return string10;
    }
    public static boolean isnumbers(String string){
      char [] data=string.toCharArray();//将字符串转换为字符数组进行遍历
        //string.length（），是String类里面的方法，data.length是data的一种属性
        for (int i=0;i<data.length;i++){
            if (data[i]<'0'||data[i]>'9'){
                return false;
            }
        }
        return true;
    }



}
