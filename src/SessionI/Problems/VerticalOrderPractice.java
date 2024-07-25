package SessionI.Problems;

//import com.sun.source.tree.Tree;

import java.util.*;

class TuplePractice {

    Node node;
    int vertical;
    int level;

    public TuplePractice(Node node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class VerticalOrderPractice {

    public static void main(String[] args) {
        Node root = new Node(1); // vertical 0 , level 0
        root.left = new Node(2); // vertical -1, level 1
        root.right = new Node(3); // vertical 1, level 1

        root.left.right = new Node(12);
        root.left.left = new Node(4); // vertical -2, level 2
        root.left.left.right = new Node(5); // vertical -1, level 3
        root.left.left.right.right = new Node(6); // vertical 0, level 4

        root.right.left = new Node(9); // vertical 0, level 2
        root.right.right = new Node(11); // vertical 2, level 2

        root.right.right.left = new Node(10); // vertical 1 , level 3

        List<List<Integer>> list = verticalTraversal(root);
        for(List<Integer> inner : list){
            System.out.print(inner);
        }
    }
    public static List<List<Integer>> verticalTraversal(Node root) {

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
            map.get(vertical).get(level).offer(node.data);

//            if(map.get(vertical).size() <= 1)
//                map.get(vertical).get(level).offer(node.data);

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
