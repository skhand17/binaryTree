package Practice;
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.left.left = new Node(4);
      root.left.right = new Node(5);

      root.right = new Node(3);
      root.right.left = new Node(6);
      root.right.right = new Node(7);


      int maxDepth = maximumDepth(root);
        System.out.println(maxDepth);
    }

    /*
    * Applying DFS
    * */
    private static int maximumDepth(Node root) {

        if(root == null)
            return 0;

        int left = maximumDepth(root.left);
        int right = maximumDepth(root.right);
        return 1 + Math.max(left, right);

    }
}
