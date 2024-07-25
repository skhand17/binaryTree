package SessionI.BFS;

import java.util.*;

public class LevelWiseTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> list = bfs(root);
        for(List<Integer> inner : list){
            System.out.print(inner + " ");
        }

    }

    public static List<List<Integer>> bfs(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return null;
        }
        queue.offer(root);

        while(!queue.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int levelNumber = queue.size();

            for(int i=0; i<levelNumber; i++) {

                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                temp.add(queue.poll().data);
            }
            result.add(temp);
        }
        return result;
    }
}
