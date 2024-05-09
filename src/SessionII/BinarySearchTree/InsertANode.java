package SessionII.BinarySearchTree;

public class InsertANode {

    public static Node insertNode(Node root, int val) {

        if (root == null) return new Node(val);
        Node current = root;
        while (true) {

            if (current.data < val) {
                if (current.right != null)
                    current = current.right;
                else {
                    current.right = new Node(val);
                    break;
                }
            } else if (current.data > val) {
                if (current.left != null)
                    current = current.left;
                else {
                    current.left = new Node(val);
                    break;
                }
            }
        }

        return root;

    }
}
