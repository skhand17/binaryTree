package Practice;

public class DiameterBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(9);

        root.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        root.right.right.right = new Node(7);
        root.right.right.right.right = new Node(8);

        int ans = diameterBinaryTree(root);
        System.out.println(ans);
    }

    private static int diameterBinaryTree(Node root) {
        int[] diameter = new int[1];

        computeDiameter(root, diameter);

        return diameter[0];
    }

    private static int computeDiameter(Node root, int[] diameter) {
        if(root == null)
            return 0;

        int left = computeDiameter(root.left, diameter);
        int right = computeDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1 + Math.max(left, right);

    }
}
