import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public void insert(long key, String type, String name) {
        TreeNode z = new TreeNode(key, type, name);
        TreeNode y = null;
        TreeNode x = root;

        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            }
            else {
                x = x.right;
            }
        }

        z.p = y;
        if (y == null) {
            root = z;
        }
        else if (z.key < y.key) {
            y.left = z;
        }
        else {
            y.right = z;
        }
    }

    public void printInOrderTraversal() {
        if (root == null) {
            return; 
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || s.size() > 0) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            System.out.print("Key: " + current.key);
            if (current.type != "") {
                System.out.print(", Type: " + current.type);
            }
            if (current.name != "") {
                System.out.print(", Name: " + current.name);
            }
            System.out.println();
            current = current.right;
        }
    }

}
