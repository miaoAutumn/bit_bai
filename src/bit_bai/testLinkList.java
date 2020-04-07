package bit_bai;

public class testLinkList {
    //单元测试
    //在实际中使用测试库进行测试
    private static void testAddFirst(){
        LinkList linkList=new LinkList();
        linkList.addFirst(1);
        linkList.addFirst(2);
        linkList.addFirst(3);
        linkList.addFirst(4);
    }
    private static void testAddLast() {
        LinkList linkList = new LinkList();
        linkList.addLast(1);
        linkList.addLast(2);
        linkList.addLast(3);
        linkList.addLast(4);
        linkList.display();
    }
    public static void testaddIndex(){
        //测试结果应该为1,4,3,2；
        LinkList linkList = new LinkList();
        linkList.addIndex(0,1);
        linkList.addIndex(1,2);
        linkList.addIndex(1,3);
        linkList.addIndex(1,4);
        linkList.display();
    }
    public static void testcontains(){
        LinkList linkList = new LinkList();
        linkList.addLast(1);
        linkList.addLast(2);
        linkList.addLast(3);
        linkList.addLast(4);
       System.out.println(linkList.contains(0));
    }
    public static void testremove(){
        LinkList linkList = new LinkList();
        //1,2,3,4
        linkList.addLast(1);
        linkList.addLast(2);
        linkList.addLast(3);
        linkList.addLast(4);
        //1,2,3
        linkList.remove(4);
        linkList.display();
    }
    public static void testremoveAll(){
        LinkList linkList = new LinkList();
        linkList.addLast(1);
        linkList.addLast(4);
        linkList.addLast(3);
        linkList.addLast(4);
        linkList.addLast(4);
        linkList.addLast(4);
        linkList.addLast(4);
        linkList.addLast(4);
       linkList.removeAll(2);
       linkList.display();
    }
    public static void main(String[] args){
//        testAddFirst();
//        testAddLast();
//        testaddIndex();
//        testcontains();
//        testremove();
      testremoveAll();
    }

}
