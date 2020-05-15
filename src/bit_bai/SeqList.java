package bit_bai;

public class SeqList {
private int [] datas=new int[100];
private int size=0;//有效元素个数，是长度
    //顺序表的最主要特点是支持随机访问能力，可以高效的按照下标来操作。

public void display(){
    //打印顺序表
    String result="[";
    for (int i=0;i<size;i++){
        result+=datas[i];
        if (i<size-1){//最后一个元素的下标
            result+=",";
        }
    }
    result+="]";
    System.out.println(result);
}
    //在pos位置新增元素data
public void add(int pos,int data){
    //判断pos的值是否为有效元素
    //边界判断放在方法里面，不破坏其封装性
    //可选择用double check;
    if (pos<0||pos>size){//是否会越界
        return;
    }
    //对数组进行扩容，当数组容量不够时会自动进行扩容
    if (size>=datas.length){
        //需要扩容
        int [] newdatas=new int[2*datas.length];
        for (int i=0;i<=size;i++){
            newdatas[i]=datas[i];
        }
        datas=newdatas;//此时datas指向newdatas地址，
                       // 原来的地址没有引用去指向它，则它会被GC垃圾回收机制回收
    }
    //1.尾插情况（较简单）将data的值插入size位置
     if (pos==size){
         datas[size]=data;
         size++;
         return;
     }
     //2.一般位置插入。从后往前访问依次向后移
    for (int i=size-1;i>=pos;i--) {
    datas[i+1]=datas[i];
    datas[pos]=data;
    size++;
    return;
    }
    }

    public boolean contains(int toFind){
    //判断是否包含某个元素。遍历数组，若数组中有元素与toFind相同，则返回true
       // 反之则返回false；
        for (int i=0;i<size;i++){
            if (datas[i]==toFind){
                return true;
            }
            }
          return false;
        }
        public int search(int toFind){
    //查找某个元素对应的下标
            for (int i=0;i<size;i++){
                if (datas[i]==toFind){
                    return i;
                }
            }
            return -1;

        }


     public Integer getPos(int pos){
    //对pos进行判断，当pos的值为非法时，返回空null
     // 但null为引用类型，int为基础类型，所以应改int为Integer；
         //对于参数非法的情况处理有两种；1.返回一个非法值（C,C++.Go）
                                      //2.抛出一个异常(java,python)
         if (pos<0||pos>size){
             return null;
         }
      return datas[pos];
     }
     public void setPos(int pos,int value){
    datas[pos]=value;
     }

     public void remove(int toRemove){//toRemo是要删除的元素值；
         //1.先找到toRemo的下标位置
         int pos =search(toRemove);//ctrl+鼠标左键可跳转到定义
         if (pos<-1){
             //没找到，则直接返回
             return;
         }
         //2.如果下标是最后一个元素直接尾删即可
         if (pos==size-1){
             size--;
             return;
         }
         //3.如果下标是中间元素，先从前往后遍历，搬运到末尾，再删除
         for (int i = pos; i <size-1 ; i++) {
             datas[i]=datas[i+1];//搬运
             size--;//删除
             return;
         }
     }
     public void clear(){
    size = 0;
     }

    }



