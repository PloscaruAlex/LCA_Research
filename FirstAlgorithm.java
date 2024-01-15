import java.util.ArrayList;

public class FirstAlgorithm {
    public static ArrayList<Integer> path1 = new ArrayList<Integer>();
    public static ArrayList<Integer> path2 = new ArrayList<Integer>();

    public static int findLCA(BinarySearchTree.Node root, int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    public static int findLCAInternal(BinarySearchTree.Node root, int n1, int n2) {
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    private static boolean findPath(BinarySearchTree.Node root, int n, ArrayList<Integer> path) {
        // base case
        if (root == null) {
            return false;
        }

        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.key);

        if (root.key == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root,
        // remove root from path[] and return false
        path.remove(path.size() - 1);

        return false;
    }
}
