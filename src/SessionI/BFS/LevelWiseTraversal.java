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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        while (!queue.isEmpty()){

            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for(int i=0; i<levelNum; i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            list.add(subList);
        }
        return list;
    }
}
