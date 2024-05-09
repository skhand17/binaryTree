package Practice;

public class LCABinarySearchTree {
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

        Node res = lcaBinarySearch(root, root.right.right, root.left);
        System.out.println(res.data);
    }

    public static Node lcaBinarySearch(Node root, Node p, Node q) {

        if(root == null)
            return null;

        if(root.data > p.data && root.data > q.data){
            lcaBinarySearch(root.left, p, q);
        }
        if(root.data < p.data && root.data < q.data){
            lcaBinarySearch(root.right, p, q);
        }
        return root;
    }
}
