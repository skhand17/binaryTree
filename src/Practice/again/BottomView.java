package Practice.again;

import java.util.*;

class TupleQue {

    Node node;
    int vertical;

    public TupleQue(Node node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}

public class BottomView {

    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);


        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> list = bottomViewPrac(root);
        System.out.println(list);
    }

    private static List<Integer> bottomViewPrac(Node root) {
        List<Integer> resultant = new ArrayList<>();
        Queue<TupleQue> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.offer(new TupleQue(root, 0));

        while (!queue.isEmpty()){
            TupleQue tupleQue = queue.poll();
            Node currentNode = tupleQue.node;
            int vertical = tupleQue.vertical;

            if(!map.containsKey(vertical)){
                map.put(vertical, currentNode.value);
            } else {
                 if(map.get(vertical) < currentNode.value)
                    map.put(vertical, currentNode.value);
            }

            if(currentNode.left != null){
                queue.offer(new TupleQue(currentNode.left, vertical - 1));
            }
            if(currentNode.right != null){
                queue.offer(new TupleQue(currentNode.right , vertical + 1));
            }
        }

        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            resultant.add(mp.getValue());
        }

        return resultant;
    }

}
