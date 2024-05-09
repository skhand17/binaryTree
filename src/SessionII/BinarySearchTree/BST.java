package SessionII.BinarySearchTree;


/**
 * @startuml
 * digraph BST {
 *   node [shape=record];
 *   4 [label="{4|{<f0>|<f1>}}"];
 *   2 [label="{2|{<f0>|<f1>}}"];
 *   6 [label="{6|{<f0>|<f1>}}"];
 *   1 [label="{1|{<f0>|<f1>}}"];
 *   3 [label="{3|{<f0>|<f1>}}"];
 *   5 [label="{5|{<f0>|<f1>}}"];
 *   7 [label="{7|{<f0>|<f1>}}"];
 *   4:f0 -> 2;
 *   4:f1 -> 6;
 *   2:f0 -> 1;
 *   2:f1 -> 3;
 *   6:f0 -> 5;
 *   6:f1 -> 7;
 * }
 * @enduml
 */
public class BST {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node node = searchInBst(root, 5);
        System.out.println(node.data);

    }


    public static Node searchInBst(Node root, int value) {

//        if(root == null)
//            return null;
//
//        if(root.data == value)
//            return root;
//
//        if(value < root.data)
//            return searchInBst(root.left, value);
//        else if(value > root.data)
//            return searchInBst(root.right, value);
//        return null;
//    }

        while(root != null && root.data != value){
            root = value < root.data ? root.left : root.right;
        }
        return root;
    }
}
