package C3AIMedBT;



public class LowestCommonAncenstor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode lca = LCA(root, root.left.right.left, root.left.right.right);
        System.out.println(lca.data);
    }

    private static TreeNode LCA(TreeNode root, TreeNode left, TreeNode right) {

        if(root == null || root == left || root == right)
            return root;

        TreeNode lt = LCA(root.left, left, right);
        TreeNode rt = LCA(root.right, left, right);

        if(lt == null){
            return rt;
        } else if(rt == null){
            return lt;
        } else {
            return root;
        }
    }
}
