package C3AIMedBT;


public class DiameterTree {

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

        int maxDiameter = diameter(root);
        System.out.println(maxDiameter);
    }

    private static int diameter(TreeNode root) {
        int[] diameter = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
    }

    private static int findDiameter(TreeNode root, int[] diameter) {

        if(root == null)
            return 0;
        int lh = findDiameter(root.left, diameter);
        int rh = findDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
