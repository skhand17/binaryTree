package SessionII.BinarySearchTree;

public class FloorInABST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right = new Node(15);

        int floor = floorInBst(root, 4);
        System.out.println(floor);
    }

    public static int floorInBst(Node root, int key) {

        int floor = -1;

        while(root != null){

            if(root.data == key)
                return root.data;

            if(key < root.data)
                root = root.left;
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
