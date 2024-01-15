import java.util.ArrayList;

class BinarySearchTree {
    /* Class containing left
       and right child of current node
     * and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() { root = null; }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

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
}
