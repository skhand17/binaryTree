package Practice;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        if (root == null)
            return result;

        boolean flag = false;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                temp.add(queue.poll().val);
            }

            if (flag) {
                Collections.reverse(temp);
            }
            flag = !flag;
            result.add(temp);

        }

        return result;

    }

}
