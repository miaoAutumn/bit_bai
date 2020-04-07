package container;

class Node{//树结构可以用链表的方式表示，较为方便
   public char value;//树中存储的数据
   public Node left;//左子树
   public Node right;//右子树

    public Node(char value) {
        this.value = value;
    }
}
public class TreeDemo {
    public static Node build(){
        //手动构建一棵树
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node h=new Node('H');
        Node i=new Node('I');
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        d.left=h;
        d.right=i;
        return a;
    }
    //求树中结点个数
    //体会递归思想，遍历树+拆分问题
    public static int getSize(Node root){
        //先考虑特殊情况：空树的话，节点个数为0
        if (root==null){
            return 0;
        }
     //访问根节点的问题：计数器+1
        //整个树树的节点=根节点个数（永恒为1）+左子树节点个数+右子树节点个数
        return 1+getSize(root.left)+getSize(root.right);
    }


    //求叶子节点的个数
    //叶子节点：没有子树，度为0的节点
    public static int getLeafSize(Node root){
        if (root==null){
            return 0;
        }
        if (root.right==null&&root.left==null){
            return 1;
        }
        //思路：递归拆分问题
        //root节点的叶子节点个数=root的左子树的叶子节点个数+右子树的叶子节点个数
        return getLeafSize(root.right)+getLeafSize(root.left);
    }


    //求第K层节点的个数
    //当k=0时，相当与是一个空树，返回0；
    //当k=1时，相当于是根节点，返回1；
    //其他：
     public static int getKLevelSize(Node root,int k){
        if (k==0||root==null){
            return 0;
        }
        if (k==1){//递归结束条件
            return 1;
        }
         //第k层节点的个数=左子树的第（k-1）层的节点个数+右子树的第（k-1）层节点的个数
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
     }


    //在二叉树中查找指定元素
    //找到返回其引用，没找到返回null
    //核心思想：递归思想拆分问题
    public static Node find(Node root,char toFind){
        if (root.value==toFind){//根节点就是所找节点
            return root;
        }
        if (root==null){//空树，肯定找不到了
            return null;
        }
        //在根节点的左子树中递归查找
        Node result=new Node(root.value);
        result=find(root.left,toFind);//实际是一个先序遍历
        //如果找到toFind，那么递归就不会向下继续进行，result的值不为null说明在左子树中，找到了
        if (result!=null){
            return result;
        }
        //如果result为null说明在左子树中未找到，则在右子树中递归查找
         return find(root.right,toFind);
    }

    //前序遍历：先访问根节点，再递归访问左子树，最后递归访问右子树
    //访问可以是打印，修改，比较...
    //注意递归结束条件：空树
    public static void preOrderTraversal(Node root){
        if (root==null){//结束条件：树是空树。null表示一个节点都没有
            return;
        }
        System.out.print(root.value+" ");//注意：这里返回的是root.val而不是root
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历：先访问左子树，再递归访问根节点，最后递归访问右子树
    public static void inOrderTraversal(Node root){
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);

    }
    //后序遍历：先访问左子树，再递归访问右子树，最后递归访问根节点
    public static void postOrderTraversal(Node root){
        if (root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");

    }

    public static void main(String[] args){
        Node node=build();
        System.out.print("前序遍历为：");
        preOrderTraversal(node);
        System.out.println();
        System.out.print("中序遍历为：");
        inOrderTraversal(node);
        System.out.println();
        System.out.print("后序遍历为：");
        postOrderTraversal(node);
        System.out.println();

        System.out.println("这棵树的节点个数为：");
        System.out.println(getSize(node));
        System.out.println("这棵树的叶子节点树是：");
        System.out.println(getLeafSize(node));
        System.out.println("第3层节点的个数是：");
        System.out.println(getKLevelSize(node,3));
        System.out.println("树中D的索引位置是：");
        System.out.println(find(node,'D'));
    }

}
