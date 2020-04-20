package container;

public class BinarySearchTree {
public static class Node{
    int val;
     public Node left;
    public Node right;

    public Node(int key) {
        this.val = key;
    }
}

   //当前树的根节点，是一颗空树
   private Node root = null;
  //在搜索树中查找key的值，如果找到返回key所在的节点，没找到返回null
   public  Node find(int key){
       Node cur = root;
       while (cur != null){
           if (cur.val == key){
               return cur;
           }
           //在右子树中找
           else if (cur.val<key){
               cur = cur.right;
           }
           //在左子树中找
           else {
               cur = cur.left;
           }
       }
       return null;
   }


   //在二叉搜索树中插入元素
  //set中是不能包含重复元素的，map中的key也不能重复
    //所以这里插入k不重复则返回true，k重复则返回false
    public boolean insert(int key){
       Node cur = root;
       //parent始终指向cur的父节点，和链表类似，因为后面需要对parent进行尾插操作
       Node parent=null;
       if (root==null){
           //为空树，直接指向新节点即可
           root = new Node(key);
           return true;
       }
       //查找合适的插入位置
       while (cur != null){
           if (cur.val<key){
               //在右子树中找
               parent=cur;
               cur=cur.right;
           }else if(cur.val>key){
               //在左子树中找
               parent = cur;
               cur=cur.left;
           }
           else {
               //说明cur。key==key，此时节点重复，插入失败
               return false;
           }
       }
       //位置查找完毕，进行插入操作
       //当循环结束后，说明此时cur==null，指向该插入节点
        //但是对插入父节点的左边还是右边还需要进行判断
        if (key < parent.val){
            //插入到左子树中
            parent.left = new Node(key);
        }else if (key > parent.val){
            //插入到右子树中
            parent.right = new Node(key);
        }
        return true;
    }

    //删除二叉搜索树的指定元素key
    //如果树中存在key就删除成功true
    //不存在key就删除失败返回false
    public boolean remove(int key){
        Node cur = root;
        Node parent = null;
        //同上述查找，找到key的位置
        while (cur != null){
            if (cur.val < key){
                //在当前节点的右子树中,记得要更新parent的值
                parent = cur;
                cur = cur.right;
            }
            else if (cur.val > key ){
                //在当前节点的左子树中
                parent = cur;
                cur = cur.left;
            }
            else {
                //说明cur.val=key，找到该节点了，开始删除操作
                removeNode(parent,cur);
                return true;
            }
        }
        //循环结束说明没找到key
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        //进行删除操作，列举多种情况
        //1.待删除节点的左子树为空，右子树非空
        if (cur.left==null){
            //1.1待删除节点是根节点
            if (cur == root){
                root = cur.right;
            }
            //1.2待删除元素是父节点的左子树
            else if (parent.left == cur){
                parent.left = cur.right;
            }
            //1.3待删除元素是父节点的左子树
            else if (parent.right == cur){
                parent.right = cur.right;
            }
        }
        //2.待删除节点左子树非空，右子树为空
        else if(cur.right==null){
            //2.1 待删除元素是根节点
            if (cur == root){
                root = cur.left;
            }
            //2.2待删除节点是父节点的左子树
            else if (parent.left == cur){
                parent.left = cur.left;
            }
            //2.3待删除节点是父节点的右子树
            else if (parent.right == cur){
                parent.right = cur.left;
            }
        }
        //3.待删除元素的左右子树都不为空
        else {
            //将未知问题转换为已知问题，在待删除节点的右子树中找最小值（向左找到尽头）或左子树中找最大值
            //将最小值覆盖在待删除元素上，然后删除最小值(替罪羊)，此时问题就转换为上面的列举情况之一
            Node goatparent=cur;
            Node scapegoat =cur.right;
            while (scapegoat.left != null){
                goatparent=scapegoat;
                scapegoat=scapegoat.left;
            }
            //循环结束后，scapegoat里面存的就是cur的右子树的左子树的最小值，赋值给待删除节点
            cur.val=goatparent.val;
            //删除最小值
            //当替罪羊是父节点的左子树时
            //因为替罪羊已经是最小值，所以他不可能有左子树，只可能有右子树
            if (goatparent.left == scapegoat){
                goatparent.left = scapegoat.right;
            }
            //在上面循环的时候若左子树为null，那么替罪羊就是cur.right本身。
            else {
                goatparent.right =scapegoat.right;
            }
        }
    }


     //先序遍历
      public static void preOrder(Node root){
       if (root == null){
           return;
       }
       System.out.print(root.val +" ");
       preOrder(root.left);
       preOrder(root.right);
      }

      //中序遍历
    public static void inOrder(Node root){
       if (root==null){
           return;
       }
           inOrder(root.left);
           System.out.print(root.val+ " ");
           inOrder(root.right);

    }

    public static void main(String[] args){
        //1.创建一颗搜索树，
        //2.随机插入一些元素
        //3.打印前序+中序
        //4.查找树中元素
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int [] k = {9,5,2,7,3,6,8};
        for (int x:k){
            binarySearchTree.insert(x);
        }

        //为了查看到树的树型结构，可以打印其先序和中序遍历，即可知道树的结构
        System.out.println("先序遍历结果为：");
      preOrder(binarySearchTree.root);
      System.out.println();
      System.out.println("中序遍历结果为:");
      inOrder(binarySearchTree.root);

      System.out.println();
      System.out.println("找到5这个元素");
     System.out.println(binarySearchTree.find(5).val);


      System.out.println("找到100这个元素");
      System.out.println(binarySearchTree.find(100).val);

      System.out.println("==================");
      binarySearchTree.remove(5);
        System.out.println("删除5后先序遍历结果为：");
        preOrder(binarySearchTree.root);
        System.out.println();
        System.out.println("删除5后中序遍历结果为:");
        inOrder(binarySearchTree.root);
    }
}
