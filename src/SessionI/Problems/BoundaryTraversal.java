package SessionI.Problems;

import java.util.ArrayList;

public class BoundaryTraversal {

    public static ArrayList<Integer> printBoundary(Node root){

        ArrayList<Integer> res = new ArrayList<>();
        if(root!=null)
            res.add(root.data);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;

    }

    private static void addRightBoundary(Node root, ArrayList<Integer> res) {
    }

    private static void addLeaves(Node root, ArrayList<Integer> res) {

    }

    private static void addLeftBoundary(Node root, ArrayList<Integer> res) {

        Node current = root.left;

        while (current != null){

        }
    }
}
