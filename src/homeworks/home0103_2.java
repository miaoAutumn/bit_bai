package homeworks;

public class home0103_2 {
    public  void exchange(int[]A,int[]B){//给定两个整型数组, 交换两个数组的内容.
        int temp=0;
        for (int i = 0, j=0; i <A .length&&j<B.length; i++,j++) {
                temp = B[j];
                B[j] = A[i];
                A[i] = temp;
            }
        }

   public static void main(String[] args){
       int [] A={1,2,3,4,5};
       int [] B={6,7,8,9,10};
       new home0103_2().exchange(A,B);
       System.out.println("交换后A的值为");
       for (int i = 0; i <A .length; i++) {
           System.out.print(A[i]+"\t");
       }
       System.out.println("\n"+"交换后B的值为");
       for (int j = 0; j <B .length; j++) {
           System.out.print(B[j]+"\t");
       }
   }


}
