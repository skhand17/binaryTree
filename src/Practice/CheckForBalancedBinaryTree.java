package Practice;
public class CheckForBalancedBinaryTree {


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

        boolean ans = isBalanced(root);
        System.out.println(ans);
        
    }

    public static boolean isBalanced(Node root) {

        if(checkBalanced(root) == -1){
            return false;
        }
        return true;
    }

    private static int checkBalanced(Node root) {

        if(root == null)
            return 0;

        int lh = checkBalanced(root.left);
        int rh = checkBalanced(root.right);

        if(lh == -1)
            return -1;

        if(rh == -1)
            return -1;

        if(Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}
