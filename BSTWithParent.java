import java.util.ArrayList;

public class BSTWithParent {
    class Node
    {
        int key;
        Node left, right, parent;

        Node(int key)
        {
            this.key = key;
            left = right = parent = null;
        }
    }

    Node root;

    public BSTWithParent() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A utility function to insert a new node with
       given key in Binary Search Tree */
    Node insertRec(Node root, int key)
    {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
        {
            root.left = insertRec(root.left, key);
            root.left.parent = root;
        }
        else if (key > root.key)
        {
            root.right = insertRec(root.right, key);
            root.right.parent = root;
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    public void edgelist(Node node, ArrayList<ArrayList<Integer>> output) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(node.key);
            a.add(node.left.key);
            output.add(a);
        }

        if (node.right != null) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(node.key);
            a.add(node.right.key);
            output.add(a);
        }
        edgelist(node.left, output);
        edgelist(node.right, output);
    }

    public void addEdge(Integer first, Integer second) {
        if (root == null) {
            insert(first);
            insert(second);
        } else {
            insert(second);
        }
    }

    public static Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }
}
