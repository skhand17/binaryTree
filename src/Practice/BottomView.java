package Practice;

import java.util.*;


class Tuple {

    Node node;
    int vertical;

    public Tuple(Node node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
public class BottomView {

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

       List<Integer> bottomViewList = bottomViewTraversal(root);
        System.out.println(bottomViewList);
    }

    private static List<Integer> bottomViewTraversal(Node root) {

        List<Integer> result = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Tuple(root, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            Node currentNode = tuple.node;
            int vertical = tuple.vertical;

            if(!map.containsKey(vertical)){
                map.put(vertical, currentNode.data);
            } else {
                if (map.get(vertical) < currentNode.data) {
                    map.put(vertical, currentNode.data);
                }
            }

            if(currentNode.left != null){
                queue.offer(new Tuple(currentNode.left, vertical - 1));
            }
            if(currentNode.right != null){
                queue.offer(new Tuple(currentNode.right, vertical + 1));
            }
        }
        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            result.add(mp.getValue());
        }

        return result;
    }

}
