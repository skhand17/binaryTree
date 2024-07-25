package C3AIMedBT;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(9);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        List<Integer> result = rightView(root);
        System.out.println(result);
    }

    public static List<Integer> rightView(TreeNode node) {
        List<Integer> result = new ArrayList<>();

        view(node, 0, result);

        return result;
    }

    private static void view(TreeNode node, int level, List<Integer> result) {

        if(node == null)
            return;

        if(level == result.size())
            result.add(node.data);

        view(node.right, level + 1, result);
        view(node.left, level + 1, result);
    }
}
