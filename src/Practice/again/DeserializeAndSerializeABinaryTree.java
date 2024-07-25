package Practice.again;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeAndSerializeABinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String serialized = serialize(root);
        System.out.println(serialized);

        Node rootNode = deserialize(serialized);
        System.out.println(rootNode.value);
        System.out.println(rootNode.left.value);
        System.out.println(rootNode.right.value);
    }

    public static String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if(node == null){
                sb.append("# ");
                continue;
            }

            sb.append(node.value + " ");
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString();
    }
    public static Node deserialize(String data) {
        if(data == "")
            return null;
        String[] split = data.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(split[0]));
        queue.offer(root);

        for(int i=1; i<split.length; i++) {
            Node parent = queue.poll();

            if(!split[i].equals("#")){
                Node leftChild = new Node(Integer.parseInt(split[i]));
                parent.left = leftChild;
                queue.offer(leftChild);
            }
            if(!split[++i].equals("#")){
                Node rightChild = new Node(Integer.parseInt(split[i]));
                parent.right = rightChild;
                queue.offer(rightChild);
            }
        }
        return root;
    }
}
