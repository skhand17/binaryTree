package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);

        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String data = serialize(root);
        System.out.println(data);

    }

    public static String serialize(Node root) {
        if (root == null)
            return "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node == null) {
                sb.append("# ");
                continue;
            }

            sb.append(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    public static Node deserialize(String data) {

        if(data == "") {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);

        for(int i=1; i<values.length; i++) {
            Node parent = queue.poll();
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!values[++i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
    }
        return root;
}


}
