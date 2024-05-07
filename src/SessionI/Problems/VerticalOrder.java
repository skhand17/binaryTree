package SessionI.Problems;


import com.sun.source.tree.Tree;

import java.util.*;

class Tuple {
    Node node;
    int row;
    int col;

    public Tuple(Node node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
public class VerticalOrder {

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

        List<List<Integer>> list = verticalTraversal(root);
        for(List<Integer> l : list){
            System.out.print(l);
        }
    }
    public static List<List<Integer>> verticalTraversal(Node root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            Node node = t.node;
            int row = t.row; // vertical
            int col = t.col; // level

            if(!map.containsKey(row))
                map.put(row, new TreeMap<>());

            if(!map.get(row).containsKey(col))
                map.get(row).put(col, new PriorityQueue<>());

            map.get(row).get(col).offer(node.data);

            if(node.left != null)
                queue.offer(new Tuple(node.left, row - 1, col + 1));

            if(node.right != null)
                queue.offer(new Tuple(node.right, row+1, col+1));

        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> tm : map.values()){
            list.add(new ArrayList<>());

            for(PriorityQueue<Integer> nodes : tm.values()){
                while(!nodes.isEmpty()){
                    System.out.println(nodes.peek());
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }
}
