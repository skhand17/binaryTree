package SessionI.Problems;


import java.util.*;

class QueuePair {
    Node node;
    int verticalLine;

    public QueuePair(Node node, int verticalLine) {
        this.node = node;
        this.verticalLine = verticalLine;
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

        List<Integer> result = bottomView(root);
        for(Integer in : result){
            System.out.print(in + " ");
        }
    }

    public static List<Integer> bottomView(Node root) {

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<QueuePair> queue = new LinkedList<>();

        queue.add(new QueuePair(root, 0));

        while (!queue.isEmpty()) {
            QueuePair qp = queue.poll();

            Node node = qp.node;
            int verticalLine = qp.verticalLine;

            if (!map.containsKey(verticalLine))
                map.put(verticalLine, node.data);
            else {
                if (map.get(verticalLine) < node.data)
                    map.put(verticalLine, node.data);
            }

            if(node.left != null)
                queue.offer(new QueuePair(node.left, verticalLine - 1));

            if(node.right != null)
                queue.offer(new QueuePair(node.right, verticalLine + 1));

        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }

        return list;
    }
}
