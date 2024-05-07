package SessionI.Problems;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
*
* This make use of BFS algo in the Trees with a flag variable
*
* */


public class ZigZagTraversal {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);

        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);

        root.right.right.left = new Node(11);
        root.right.right.right = new Node(12);


        boolean flag = false;

        List<List<Integer>> list = zigzag(root, flag);

        for (List<Integer> inner : list) {
            System.out.print(inner);
        }
    }

    public static List<List<Integer>> zigzag(Node root, boolean flag) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        while (!queue.isEmpty()) {

            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            if (flag)
                Collections.reverse(subList);
            flag = !flag;
            list.add(subList);
        }
        return list;
    }
}
