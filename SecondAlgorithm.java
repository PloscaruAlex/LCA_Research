import java.util.HashMap;
import java.util.Map;

public class SecondAlgorithm {
    public static int findLCA(BSTWithParent.Node root, Integer n1, Integer n2) {
        BSTWithParent.Node node1 = BSTWithParent.search(root, n1);
        BSTWithParent.Node node2 = BSTWithParent.search(root, n2);
        Map<BSTWithParent.Node, Boolean> ancestors = new HashMap<BSTWithParent.Node, Boolean>();
        while (node1 != null) {
            ancestors.put(node1, Boolean.TRUE);
            node1 = node1.parent;
        }

        while (node2 != null) {
            if (ancestors.containsKey(node2) != ancestors.isEmpty()) {
                return node2.key;
            }
            node2 = node2.parent;
        }

        return -1;
    }
}
