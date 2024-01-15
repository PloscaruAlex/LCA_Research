import java.util.ArrayList;
import java.util.Arrays;

public class ThirdAlgorithm {
    // ArrayList to store tree
    static ArrayList<Integer> tree[];
    static int memo[][];
    static int log;

    public ThirdAlgorithm(int numberOfNodes, BinarySearchTree binaryTree) {
        tree = new ArrayList[numberOfNodes + 1];
        log = (int)Math.ceil(Math.log(numberOfNodes) / Math.log(2));
        memo = new int[numberOfNodes + 1][log + 1];
        for (int i = 0; i <= numberOfNodes; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i <= numberOfNodes; i++) {
            tree[i] = new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        binaryTree.edgelist(binaryTree.root, list);
        for (ArrayList<Integer> edge : list) {
            tree[edge.get(0)].add(edge.get(1));
            tree[edge.get(1)].add(edge.get(0));
        }

        dfs(binaryTree.root.key, binaryTree.root.key);
    }

    public static int levelOf(BinarySearchTree.Node root, int key, int level) {
        if (root == null) {
            return 0;
        }
        if (root.key == key) {
            return level;
        }
        int result = levelOf(root.left, key, level + 1);
        if (result != 0) {
            return result;
        }
        result = levelOf(root.right, key, level + 1);
        return result;
    }

    // Pre-processing to calculate values of memo[][]
    static void dfs(int node, int parent)
    {

        // Using recursion formula to calculate
        // the values of memo[][]
        memo[node][0] = parent;
        for (int i = 1; i <= log; i++) {
            memo[node][i] = memo[memo[node][i - 1]][i - 1];
        }
        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node);
            }
        }
    }

    // Function to return the LCA of nodes u and v
    public static int findLCA(BinarySearchTree.Node root, int node1, int node2)
    {
        // The node which is present farthest
        // from the root node is taken as u
        // If v is farther from root node
        // then swap the two
        if (levelOf(root, node1, 1) < levelOf(root, node2, 1)) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        // Finding the ancestor of u
        // which is at same level as v
        for (int i = log; i >= 0; i--) {
            if ((levelOf(root, node1, 1) - (int)Math.pow(2, i)) >= levelOf(root, node2, 1))
                node1 = memo[node1][i];
        }

        // If v is the ancestor of u
        // then v is the LCA of u and v
        if (node1 == node2)
            return node1;

        // Finding the node closest to the root which is
        // not the common ancestor of u and v i.e. a node
        // x such that x is not the common ancestor of u
        // and v but memo[x][0] is
        for (int i = log; i >= 0; i--) {
            if (memo[node1][i] != memo[node2][i]) {
                node1 = memo[node1][i];
                node2 = memo[node2][i];
            }
        }

        // Returning the first ancestor
        // of above found node
        return memo[node1][0];
    }
}
