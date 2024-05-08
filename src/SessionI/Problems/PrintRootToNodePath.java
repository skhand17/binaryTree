package SessionI.Problems;

import java.util.ArrayList;

public class PrintRootToNodePath {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        ArrayList<Integer> list = solve(root, 6);
        for(int i: list){
            System.out.print(i + " ");
        }

    }

    public static ArrayList<Integer> solve(Node root, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        getPath(result, root, B);
        return result;
    }

    private static boolean getPath(ArrayList<Integer> result, Node root, int b) {

        if(root == null)
            return false;
        result.add(root.data);

        if(root.data == b)
            return true;

        if(getPath(result, root.left, b) || getPath(result, root.right, b))
            return true;

        result.remove(result.size() - 1);
        return false;
    }
}
