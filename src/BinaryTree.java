import java.util.Stack;

public class BinaryTree {
    TreeNode root; //initialize binary search tree root object 

    /* 
    Description: This function adds a node to the tree while maintaining the binary search tree properties
    Parameters: 
    TreeNode z - the TreeNode object to be added
    Returns: Nothing
     */ 
    public void insert(TreeNode z) {
        TreeNode y = null; //initialize temp TreeNode variable
        TreeNode x = root; //initialize the BST root 

        while (x != null) {
            y = x; //set the value of y to current node
            if (z.key < x.key) { //if the key to be added is less than the current key
                x = x.left; //set the current node to the left child
            }
            else { 
                x = x.right; //else set the current node to the right child
            }
        }

        z.p = y; //set the value of the parent of the node to be added to y, the appropriate position for the node to be added found in the previous while loop
        if (y == null) { //if the parent does not exist 
            root = z; //the tree is empty and the node becomes the root
        }
        else if (z.key < y.key) { //if the node's key is less than the parents key
            y.left = z; //set the node to the left child of the parent
        }
        else {
            y.right = z; //set the node to the right child of the parent
        }
    }

    /* 
    Description: This function traverses the tree using in-order traversal and prints each TreeNode object's key, type (if given), and name
    Parameters: None
    Returns: Nothing
     */
    public void printInOrderTraversal() {
        if (root == null) { //if the root is null 
            return; //then the tree is empty and return nothing
        }
        Stack<TreeNode> s = new Stack<TreeNode>(); //initialize a stack
        TreeNode current = root; //set the current node to root
        while (current != null || s.size() > 0) { //loop until all nodes have been visited and the stack is empty
            while (current != null) { //traverse to the leftmost subtree and push the nodes onto the stack
                s.push(current); //push the current node
                current = current.left; //set the current node to the left child 
            }
            current = s.pop(); //pop the current node from the stack
            System.out.print("Key: " + current.key); //print the current node's key
            if (current.type != "") { //if the current node has a type 
                System.out.print(", Type: " + current.type); //print the current node's type
            }
            System.out.print(", Name: " + current.name); //print the current nodes' name
            System.out.println(); //print empty line for ease of reading
            current = current.right; //set the current node to the right child
        }
    }

    /* 
    Description: search() searches the tree by comparing the target key to the current node's key, moving to the left child if the node's is lower than the target and the right if not
    Parameters:
    TreeNode node - The starting node that the search function is called on
    Long key - The target key that the search function compare's each TreeNode object's key to
    Returns:
    TreeNode node - The node with the key matching the target key
     */
    public TreeNode search(TreeNode node, Long key) {
        while (node != null && key != node.key) { //while the current node is not null and the key is not the key of the current node
            if (key < node.key) { //if the target key is less than key of the current node
                node = node.left; //set the current node to the left child
            }
            else {
                node = node.right; //set the current node to the right child
            }
        }
        return node; //return the current node after exiting the while loop, meaning it has a matching key
    }

}
