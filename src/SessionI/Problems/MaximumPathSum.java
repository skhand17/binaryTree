package SessionI.Problems;

/*
* Very good question
*
* */

public class MaximumPathSum {

    public static void main(String[] args) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);

        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int max = maxPathSum(root);
        System.out.println(max);
    }

    public static int maxPathSum(Node root) {
        /*
        * This array is just like a backtracking to store the maximum value in a path sum
        * */
        int [] sum = new int[1];

        maxPathSumCal(sum, root);

        return sum[0];
    }

    private static int maxPathSumCal(int[] maxSum, Node root) {

        if(root == null)
            return Integer.MIN_VALUE;

        int lh = Math.max(0, maxPathSumCal(maxSum, root.left));
        int rh = Math.max(0, maxPathSumCal(maxSum, root.right));
        maxSum[0] = Math.max(maxSum[0], root.data + lh + rh);
        return root.data + Math.max(lh, rh);
    }
}
