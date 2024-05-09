package SessionII.BinarySearchTree;

public class CielInBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);

        root.left.right = new Node(6);
        root.left.right.right = new Node(9);

        root.right = new Node(13);
        root.right.left = new Node(11);
        root.right.right = new Node(14);

        int ceil = cielInBst(root, 7);
        System.out.println(ceil);
    }

    public static int cielInBst(Node root, int key) {

        int ceil = -1;

        while(root != null) {

            if(root.data == key)
                return root.data;
            if (key > root.data)
                root = root.right;
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
