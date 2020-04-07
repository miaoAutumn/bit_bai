package container;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

     public TreeNode(int val) {
         this.val = val;
     }
 }
public class TreeInterview {
    //    static List<Integer> result = new ArrayList<>();
    //二叉树的前序遍历 力扣144
    //与之前不同的是此处要将遍历结果放在list中，之前是直接打印
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //包装类 int=>Integer
        // List<Integer> result=new List<Integer>() ;//List是个接口，不能直接实例化对象.应该用他的实现类ArrayList
        if (root == null) {//空树，返回一个空的List。注意：是 List里的元素个数为0，但不是null。
            // List是个盒子，盒子里面没东西是空，连盒子都没有，是null
            return result;
        }
        //访问根节点，这里访问也就是指将root的值add进List中
        result.add(root.val);
        //递归访问左子树，将左子树的值addall进list中
        //addAll是将根的左子树的所有节点都加进list，List是一个长度可变的线性表
        //每递归一次就会创建一个List（List的引用是result），将节点值加进List。最后将所有的List加进总的list中
        result.addAll(preOrderTraversal(root.left));
        //递归遍历右子树,将右子树的节点加入List中
        result.addAll(preOrderTraversal(root.right));
        return result;

    }


    //二叉树的中序遍历 力扣94
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;

    }


    //二叉树的后序遍历 力扣145
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }


    //检查两棵树是否相同 力扣100
    //思路：先看根节点是否相同，再递归比较左子树和右子树是否相同
    //思路2.先序+中序或者中序+后序的结果相同，则是相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //可分为3种情况：1.pq都为空，相同
        //2.pq只有一个为空，不相同
        //3.pq都不为空，比较完根节点后，进入递归比较
        if (p == null && q == null) {//两颗空树，肯定相同
            return true;
        }
//  if ((p==null&&q!=null||(p!=null&&q==null)){}//其中一颗为空树，肯定不相同
        //上述代码可简化成下面;
        // 因为第一个if已经对pq=null进行过判断，所以当执行第二个if时，一定是pq只有一个为null
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {//根节点相同时，递归比较左右子树，左右子树都相同才返回true
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }

    }


    //一棵树是另一颗树的子树，思路同上 力扣572
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {//两棵空树，互为子树
            return true;
        }
        if (s == null || t == null) {//其中一颗为空树，则肯定为false
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);//如果根节点相同，则看这两棵树是不是相同，相同就是子树
        }
        if (ret == false) {//如果s，t不相同，那么就递归在s的左子树中找t。
            ret = isSubtree(s.left, t);
        }
        if (ret == false) {//如果在s的左子树中没找到，那就在右子树中找
            ret = isSubtree(s.right, t);
        }
        return ret;
    }

    //二叉树的最大深度 力扣104
    //二叉树的深度：根节点到最远叶子节点的最长路径上的节点数。
    //叶子结点：没有子树的节点
    //思路：最大深度=max（左子树的深度，右子树的深度）+1（1是根节点）
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int result = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return result;
    }

    //判断一棵树是否为平衡二叉树 力扣110
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    //思路：一棵树是否平衡：
    //1.自己的左右子树高度差是否<=1;
    //2.&&左右子树是否分别为平衡二叉树（递归判断）；
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            //空树认为是平衡的
            return true;
        }
        if (root.left == null && root.right == null) {
            //没有节点也认为是平衡的
            return true;
        }
        //第一步：自己的左右子树高度差是否<=1;
        int leftDepth = maxDepth(root.right);
        int rightDepth = maxDepth(root.left);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {//记得是比较绝对值
            return false;
        }
        //第二步：&&左右子树是否分别为平衡二叉树（递归判断）
        return isBalanced(root.right) && isBalanced(root.left);
    }


    //给定一个二叉树，检查它是否是镜像对称的。力扣101
    //思路：先判断root的左子树和右子树是否为镜像关系再判断左子树和右子树是否根节点值是否相同
    //再判断左树的左孩子与右树的右孩子是否相同&&左树的右孩子和右树的左孩子是否相同
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);//调用一个辅助方法

    }

    private boolean isMirror(TreeNode l, TreeNode r) {
        //3种情况
        //左右子树都为空
        if (l == null && r == null) {
            return true;
        }
        //左右子树只有一个为空的情况
        if (l == null || r == null) {
            return false;
        }
        //如果左右子树的根节点值不同，那肯定不是镜像
        if (l.val != r.val) {
            return false;
        }
        //左右子树都不为空,递归比较左右子树的左右子树是否为镜像
        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }


    //二叉树的层序遍历
    //不能用递归做，需要创建一个空队列
    public static void levelOrderTraversal(TreeNode root) {
        //思路：1.将根节点入队列，如果队列不为空，访问（打印）队首元素出队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {//队列不为空，则代表层序遍历还没结束
            //如果队列不为空，则取出队首元素
            TreeNode t = queue.poll();
            System.out.print(t.val + " ");
            // 2.如果左右子树不为空，就将左右子树入队列，然后访问（打印）队首元素出队列(循环了)
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
        }
    }


    //判断一颗树是否为完全二叉树
    boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean secondStage = false;//第二阶段标志位，因为刚开始都是处于第一阶段，所以默认为false
        queue.offer(root);
        if (root == null) {
            return true;//空树一定是完全二叉树
        }
        while (!queue.isEmpty()) {
            //针对当前节点进行访问，这个访问指进行判断
            TreeNode cur = queue.poll();
            if (secondStage == false) {
                //左右子树都不为空，第一阶段，入队列
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                //左子树不为空，右子树为空，切换到第二阶段，入队列
                if (cur.left != null && cur.right == null) {
                    queue.offer(cur.left);
                    secondStage = true;//切换阶段
                }
                //左子树为空，右子树不为空，一定不是完全二叉树不符合规则
                if (cur.left == null && cur.right != null) {
                    return false;
                }
                //左右子树都为空,切换至第二阶段
                if (cur.right == null && cur.left == null) {
                    secondStage = true;
                }
            }
            //第二阶段,所以节点都不能有左右子树
            else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }

            }

        }
        //当所有条件都判断完，也没有找到反例，则说明该树是一颗完全二叉树
        return true;
    }


  //二叉树的分层遍历 力扣102
    //创建一个result用来存储每一层的节点
    //result相当于是一个二维数组
    //针对当前的ArrayList而言，（包含所有元素）每一层的元素集合就是一个List
    //result 0对应的就是第0层元素的集合
    //result 1对应的就是第一层元素的集合
    //注意：在线OJ 有多组例子，所以每次调用static都需要清空一次。
     static List<List<Integer>> result=new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
   //要把每一层的节点放到一个单独的list中，所以不能使用之前的层序遍历方法
   // 还是通过递归来实现
    //清空result，让它保持为空List
            result.clear();
            if (root==null){
                return result;
            }
            help(root,0);
           return result;
        }
public static void help(TreeNode root,int level){
            //给level对应的层里添加ArrayList
    if (level==result.size()){
        result.add(new ArrayList<>());//防止下标越界情况
    }
    //把当前节点添加到arrayList的合适位置
    result.get(level).add(root.val);
    if (root.left!=null){
        //继续向下添加，更新level
        help(root.left,level+1);
    }
    if (root.right!=null){
        help(root.right,level+1);
    }
}


//    public static TreeNode build() {
//        //手动构建一棵树
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        TreeNode f = new TreeNode(6);
//        TreeNode h = new TreeNode(7);
//        TreeNode i = new TreeNode(8);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        d.left = h;
//        d.right = i;
//        return a;
//    }

    //    public static void main(String[] args) {
//        TreeNode node = build();
////        List<Integer> result = new ArrayList<>();
////        System.out.print("前序遍历为：");
////        System.out.println();
//        System.out.println("层序遍历结果为：");
//       levelOrderTraversal(node);
    //二叉树的构建及遍历：
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //因为在线OJ中的一般都是多组输入的，所以要循环输入
        while (scanner.hasNext()) {
            //这里的line里输入的是一组形如abc##de#g##f###的先序遍历二叉树值（根左右）
            String line = scanner.next();
            //根据输入的line值去构建树
            TreeInterview treeInterview=new TreeInterview();
            TreeNode root = treeInterview.build(line);
            //再对该树进行中序遍历
           inorderTraversal(root);
            //在线oj的输出一定要注意，要符合题目要求。若是多个空格或者少个空格则都不能通过
            System.out.println();


            TreeInterview t = new TreeInterview();
            t.preOrderTraversal(root);
        }




    }

    //构建这棵树时，为了知道在后面递归过程中知道是line中哪个元素
    // 需要一个标志位，用来追踪是line中那个元素
    public static int index=0;
    private TreeNode build(String line) {
        index = 0;//从line的0号元素开始
        //通过一个辅助方法来构建
        return creatTreePreOeder(line);
    }
    private static TreeNode creatTreePreOeder(String line) {
        //通过index来获取当前执行的是哪个元素
        char cur = line.charAt(index);
            if (cur == '#') {
                return null;//#代表当前元素没有左右子树
            }
            //如果当前cur的值不是#，就创建一个节点，
            TreeNode node = new TreeNode(cur);
            //更新index的值，下一个节点开始就是当前cur的左子树的前序遍历结果
            index++;
            node.left = creatTreePreOeder(line);//index的值已更新
            index++;
            //左子树遍历完，开始遍历右子树
            node.right = creatTreePreOeder(line);
            return node;
    }
    public  void inorderTraversal(Node root){
        if (root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.value+" ");
        inorderTraversal(root.right);

    }
}



