package container;

class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int val) {
        this.val = val;
    }
}
public class TreeInterview2 {
    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 力口236
    //lca表示最近公共祖先
    private TreeNode2 lca=null;
    public TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
     if (root==null){
         return null;
     }
     //辅助调用一个toFind方法，如果在tofind中找到最近公告祖先就返回给lca。
     toFind(root,p,q);
     return lca;
    }

   //从root出发，看看能不能找到pq，找到返回1，找不到返回0
    private boolean toFind(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root==null){
            return false;
        }
        //递归后序遍历查找pq；
        //pq的位置有三种，左子树，右子树，当前根节点
        int left=toFind(root.left,p,q)?1:0;
        int right=toFind(root.right,p,q)?1:0;
        int mid=(root==p||root==q)?1:0;
        //pq要在3中情况的两个位置，才能判定该节点是lca
       if (left+right+mid==2){
           lca=root;
       }
       //说明有找到
       return left+right+mid>0;

    }


}
