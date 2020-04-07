package bit_bai;

public class Test {
    private  static void testContains(){
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        System.out.println(seqList.contains(2));
    }
    private static void textSecrch(){
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        System.out.println(seqList.search(2));
    }
    private static void textRemove(){
        SeqList seqList=new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.remove(4);
        seqList.display();

    }
    public static void main(String[] args){
//       testContains();
//       int [] a=new int[]{3,5,9,0,6,};
//       ArrayTest.bubbleSort(a);
//       ArrayTest.reversr(a);
//        textSecrch();
        textRemove();
    }
    
}
