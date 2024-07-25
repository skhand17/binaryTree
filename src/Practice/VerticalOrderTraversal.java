package Practice;

import java.util.*;


class QueueTuple {

    Node node;
    int vertical;
    int level;

    public QueueTuple(Node node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class VerticalOrderTraversal {

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

        List<List<Integer>> verticalList = verticalTraversal(root);
        for(List<Integer> integerList : verticalList){
            System.out.println(integerList);
        }

    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<QueueTuple> queue = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        queue.add(new QueueTuple(root, 0, 0));

        while (!queue.isEmpty()){
            QueueTuple tuple = queue.poll();

            Node currentNode = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(currentNode.data);

            if(currentNode.left != null){
                queue.offer(new QueueTuple(currentNode.left, vertical - 1, level +1));
            }

            if(currentNode.right != null){
                queue.offer(new QueueTuple(currentNode.right, vertical + 1, level + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> innerMap : map.values()){
            result.add(new ArrayList<>());

            for(PriorityQueue<Integer> priorityQueue : innerMap.values()){

                while (!priorityQueue.isEmpty()){
                    result.get(result.size() - 1).add(priorityQueue.poll());
                }
            }
        }

        return result;
    }
}
