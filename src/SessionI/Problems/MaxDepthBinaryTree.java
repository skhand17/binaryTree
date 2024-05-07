package SessionI.Problems;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        root.right.left.left = new Node(5);


        int max = maxDepthDFS(root);
        System.out.println(max);
    }
    /*
    *
    * Simple Recurrence Relation 1 + Max(left, right)
    * TC : O(n)
    * SC : O(n)
    * */
    private static int maxDepthDFS(Node root) {

        if(root == null)
            return 0;

        int lh = maxDepthDFS(root.left);
        int rh = maxDepthDFS(root.right);
        return 1 + Math.max(lh, rh);
    }
}
