package SessionI.DFS;

public class PostOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        postOrder(root);
    }

    private static void postOrder(Node root) {

        if(root == null)
            return;

        postOrder(root.left);
//        System.out.println(root.data);
        postOrder(root.right);

        System.out.print(root.data + " ");
    }
}
