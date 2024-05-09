package SessionI.Problems;

public class FlattenBinaryTreeToLinkedList {

    static Node previous = null;
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        flattenBinaryTree(root);

        while(root!=null){
            System.out.print(root.data + " -> ");
            root = root.right;
        }
//        System.out.println(root.data);


    }

    public static void flattenBinaryTree(Node root) {

        if(root == null)
            return;

        flattenBinaryTree(root.right);
        flattenBinaryTree(root.left);

        root.right = previous;
        root.left = null;
        previous = root;
    }
}
