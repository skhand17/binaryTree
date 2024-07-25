package C3AIMedBT;


class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(9);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        boolean isBalanced = check(root);
        System.out.println(isBalanced);
    }

    public static boolean check(TreeNode root) {

        if(checkBalanced(root) == -1){
            return false;
        }
        return true;
    }

    private static int checkBalanced(TreeNode root) {

        if(root == null)
            return 0;

        int lh = checkBalanced(root.left);
        int rh = checkBalanced(root.right);

        if(lh == -1)
            return -1;
        if(rh == -1)
            return -1;
        if(Math.abs(lh - rh) >  1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}
