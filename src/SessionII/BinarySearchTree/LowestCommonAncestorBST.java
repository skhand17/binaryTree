package SessionII.BinarySearchTree;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        Node res = lca(root, root.right.right, root.left);
        System.out.println(res.data);

    }

    public static Node lca(Node root, Node p, Node q) {

        if(root == null) return null;

        int current = root.data;

        if(current < p.data && current < q.data){
            lca(root.right, p, q);
        }
        if(current > p.data && current > q.data){
            lca(root.left, p, q);
        }
        return root;
    }
}
