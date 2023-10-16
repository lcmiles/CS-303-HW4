public class TreeNode {
    
    long key; //represents the UPC or key
    String type; //represents the weight, amount, or type of item
    String name; //represents the name of the item
    TreeNode left; //represents the left child
    TreeNode right; //represents the right child
    TreeNode p; //represents the parent node

    public TreeNode(long key, String type, String name) { //constructor for the node objects
        this.key = key;
        this. type = type;
        this.name = name;
        this.p = null;
    }
}
