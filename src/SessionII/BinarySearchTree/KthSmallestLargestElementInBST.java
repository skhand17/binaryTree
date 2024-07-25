package SessionII.BinarySearchTree;

public class KthSmallestLargestElementInBST {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.left.right = new Node(2);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int[]counter = new int[]{0};
        int[]kSmallest = new int[1];
        int[]kLargest = new int[1];
        kSmallestElement(root, 3, counter, kSmallest);
        System.out.println(kSmallest[0]);
        counter[0] = 0;
        kLargestElement(root, 2, counter, kLargest);
        System.out.println(kLargest[0]);

    }

    public static void kSmallestElement(Node root, int k, int[]counter, int[] kSmallest) {

        if(root == null || counter[0] >= k)
            return;

        kSmallestElement(root.left, k, counter, kSmallest);
        counter[0]++;

        if(counter[0] == k){
            kSmallest[0] = root.data;
            return;
        }

        kSmallestElement(root.right, k, counter, kSmallest);
    }

    public static void kLargestElement(Node root, int k, int[]counter, int[]klargest) {

        if(root == null || counter[0] >= k)
            return;
        kLargestElement(root.right, k, counter, klargest);
        counter[0]++;

        if(counter[0] == k){
            klargest[0] = root.data;
            return;
        }
        kLargestElement(root.left, k, counter, klargest);
    }
}
