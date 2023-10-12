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
        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        System.out.print("key: " + node.key + ", Type: " + node.type + ", Name: " + node.name);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

}
