package Practice;

import java.util.*;

public class TopView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(10);

        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        root.right.left = new Node(9);
        root.right.right = new Node(10);

        List<List<Integer>> verticalList = topViewTraversal(root);
        for(List<Integer> integerList : verticalList){
            System.out.println(integerList);
        }
    }

    public static List<List<Integer>> topViewTraversal(Node root) {

        Queue<QueueTuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        List<List<Integer>> result = new ArrayList<>();

        queue.offer(new QueueTuple(root, 0, 0));

        while (!queue.isEmpty()){
            QueueTuple queueTuple = queue.poll();
            Node currentNode = queueTuple.node;
            int vertical = queueTuple.vertical;
            int level = queueTuple.level;


            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            if(map.get(vertical).size() <= 1){
                map.get(vertical).get(level).offer(currentNode.data);
            }

            if(currentNode.left != null){
                queue.offer(new QueueTuple(currentNode.left, vertical - 1, level + 1));
            }
            if(currentNode.right != null){
                queue.offer(new QueueTuple(currentNode.right, vertical + 1, level + 1));
            }

        }

        for(TreeMap<Integer, PriorityQueue<Integer>> treeMap : map.values()){
            result.add(new ArrayList<>());

            for(PriorityQueue<Integer> priorityQueue : treeMap.values()) {
                while(!priorityQueue.isEmpty()){
                    result.get(result.size() - 1).add(priorityQueue.poll());
                }
            }
        }

        return result;
    }
}
