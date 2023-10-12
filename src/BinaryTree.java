import java.io.PrintStream;

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

    public void inOrderTraversal(TreeNode node) {
        PrintStream stream = new PrintStream(System.out);
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        stream.print("Key: " + node.key);
        if (node.type != null) {
            stream.print(", Type: " + node.type);
        }
        if (node.name != null) {
            stream.print(", Name: " + node.name);
        }
        stream.println();
        inOrderTraversal(node.right);
        stream.close();
    }

    public void printInOrderTraversal() {
        inOrderTraversal(root);
    }

}
