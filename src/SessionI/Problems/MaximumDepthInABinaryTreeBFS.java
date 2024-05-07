package SessionI.Problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Apply BFS technique to find the maximum depth
*
* */
public class MaximumDepthInABinaryTreeBFS {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        root.right.left.left = new Node(5);


        int max = maxDepth(root);
        System.out.println(max);
    }

    public static int maxDepth(Node root) {

        List<List<Integer>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null)
            return 0;

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> tempList = new LinkedList<>();

            for(int i=0; i<levelNum; i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                tempList.add(queue.poll().data);
            }
            list.add(tempList);

        }
        return list.size();
    }
}
