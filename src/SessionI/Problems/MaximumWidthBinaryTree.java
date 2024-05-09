package SessionI.Problems;


import java.util.LinkedList;
import java.util.Queue;

/*
* TC: O(n)
* SC: O(n)
*
* */

class PairMaxWidth {

    Node node;
    int index;

    public PairMaxWidth(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthBinaryTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        root.left.left = new Node(5);
        root.left.left.left = new Node(7);

        root.right.right = new Node(4);
        root.right.right.right = new Node(6);


        int maxWidth = maximumWidth(root);
        System.out.println(maxWidth);
    }

    public static int maximumWidth(Node root) {

        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<PairMaxWidth> queue = new LinkedList<>();

        queue.offer(new PairMaxWidth(root, 0));

        while (!queue.isEmpty()) {

            int sizeOfQueue = queue.size();
            int minimum = queue.peek().index; // this gives me the minimum index at any level. Used to reset the indexing of children nodes in below level
            int first = 0;
            int last = 0;

            for (int i = 0; i < sizeOfQueue; i++) {
                int currentId = queue.peek().index - minimum;
                Node node = queue.peek().node;
                queue.poll();

                if (i == 0) first = currentId;
                if (i == sizeOfQueue - 1) last = currentId;
                if (node.left != null)
                    queue.offer(new PairMaxWidth(node.left, 2 * currentId + 1));
                if (node.right != null)
                    queue.offer(new PairMaxWidth(node.right, 2 * currentId + 2));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}
