package SessionI.Problems;

public class IdenticalTrees {

    public static void main(String[] args) {

        /*
        * TREE-I
        *
        * */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);
//        int nodes = 6;
//        int counter=-1;
//        int[] arr = new int[nodes];
//        preOrderTraversal(root, nodes, counter, arr);
//        for(int i=0; i<nodes; i++){
//            System.out.println(arr[i] + " ");
//        }

        /*
        *
        * TREE-II
        *
        * */
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        root2.right.left = new Node(4);
        root2.right.right = new Node(5);

        boolean isSame = identicalTrees(root,root2);
        System.out.println(isSame);

    }

    public static boolean identicalTrees(Node root, Node root2) {

        if(root == null || root2 == null)
            return root == root2;

        return (root.data == root2.data) && identicalTrees(root.left, root2.left) && identicalTrees(root.right, root2.right);
    }

}
