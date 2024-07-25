package Practice.again;

import java.util.*;

class Tuple {

    Node node;
    int vertical;
    int level;

    public Tuple(Node node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
public class VerticalTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.left = new Node(9);

        List<List<Integer>> list = verticalTraversal(root);
        for(List<Integer> inner : list){
            System.out.println(inner);
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> resultant = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int vertical = tuple.vertical;
            int level = tuple.level;
            Node currentNode = tuple.node;

            if(!treeMap.containsKey(vertical)){
                treeMap.put(vertical, new TreeMap<>());
            }
            if(!treeMap.get(vertical).containsKey(level)){
                treeMap.get(vertical).put(level, new PriorityQueue<>());
            }

            treeMap.get(vertical).get(level).offer(currentNode.value);

            if(currentNode.left != null){
                queue.offer(new Tuple(currentNode.left, vertical - 1, level + 1));
            }

            if(currentNode.right != null){
                queue.offer(new Tuple(currentNode.right, vertical + 1, level + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> tm : treeMap.values()){
            resultant.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : tm.values()) {

                while (!pq.isEmpty()){
                    resultant.get(resultant.size() - 1).add(pq.poll());
                }
            }
        }
        return resultant;
    }
}
