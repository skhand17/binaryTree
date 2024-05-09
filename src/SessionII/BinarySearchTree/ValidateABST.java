package SessionII.BinarySearchTree;

public class ValidateABST {

    public static void main(String[] args) {

        Node root = new Node(13);
        root.left = new Node(10);
        root.left.left = new Node(7);
        root.left.right = new Node(12);

        root.left.left.right = new Node(9);
        root.left.left.right.left = new Node(8);

        boolean isValid = validBST(root);
        System.out.println(isValid);

    }

    public static boolean validBST(Node root){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(Node root, int minValue, int maxValue) {

        if(root == null)
            return true;

        if(root.data > maxValue || root.data < minValue)
            return false;
        return isValidBST(root.left, minValue, root.data) && isValidBST(root.right, root.data, maxValue);
    }
}
