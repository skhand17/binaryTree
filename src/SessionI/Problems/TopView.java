package SessionI.Problems;

import java.util.*;

public class TopView {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        root.right = new Node(3);
        root.right.right = new Node(7);

        List<List<Integer>> result = topView(root);
        for(List<Integer> inner : result){
            System.out.print(inner);
        }
    }

    public static List<List<Integer>> topView(Node root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<TuplePractice> queue = new LinkedList<>();

        queue.offer(new TuplePractice(root, 0, 0));


        while(!queue.isEmpty()){

            TuplePractice tp = queue.poll();
            Node node = tp.node;
            int vertical = tp.vertical;
            int level = tp.level;

            if(!map.containsKey(vertical))
                map.put(vertical, new TreeMap<>());

            if(!map.get(vertical).containsKey(level))
                map.get(vertical).put(level, new PriorityQueue<>());

            if(map.get(vertical).size() <= 1)
                map.get(vertical).get(level).offer(node.data);

            if(node.left != null)
                queue.offer(new TuplePractice(node.left, vertical - 1, level + 1));

            if(node.right != null)
                queue.offer(new TuplePractice(node.right, vertical + 1, level + 1));
        }

        List<List<Integer>> returnList = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> innerTreeMap : map.values()){
            returnList.add(new ArrayList<>());
            for(PriorityQueue<Integer> priorityQueue : innerTreeMap.values()){

                while(!priorityQueue.isEmpty()){
                    System.out.println(priorityQueue.peek());
                    returnList.get(returnList.size() - 1).add(priorityQueue.poll());
                }
            }
        }


        return returnList;
    }
}
