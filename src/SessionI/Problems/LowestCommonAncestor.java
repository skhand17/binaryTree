package SessionI.Problems;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left  = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node lowestCommonAncenstor = lca(root,root.left.left,root.right.right);
        System.out.println(lowestCommonAncenstor.data);
    }

    public static Node lca(Node root, Node p, Node q) {

        if (root == null || root == p || root == q)
            return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else {
            return root;
        }
    }


}
