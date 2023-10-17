public class TreeNode {
    
    long key; //represents the UPC or key
    String amount; //represents the weight, amount, or amount of item
    String name; //represents the name of the item
    TreeNode left; //represents the left child
    TreeNode right; //represents the right child
    TreeNode p; //represents the parent node

    public TreeNode(long key, String amount, String name) { //constructor for the node objects
        this.key = key;
        this. amount = amount;
        this.name = name;
        this.p = null;
    }
}
