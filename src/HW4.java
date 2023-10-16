import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HW4 {

    static String file = "UPC.csv"; //initialize CSV file name
    static String file2 = "input.dat"; //initialize iput data file name
    static ArrayList<TreeNode> items = new ArrayList<TreeNode>(); //initialize array list for storing items from the CSV file
    static ArrayList<Long> keys = new ArrayList<Long>(); //initialize array list for storing search target keys

    /* 
    Description: main() reads both the CSV and input files then calls the functions to construct the binary search tree, print the results, and search/print the keys given in the input file
    Parameters:
    Strings[] args - Runtime arguments
    Returns: Nothing
     */
    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();

        try {
            Scanner scanner = new Scanner(new File(file)); //initialize reader in csv file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); //split read line at each comma into an array of 3 strings 
                if (parts.length == 3) {
                    long key = Long.parseLong(parts[0]); //parse long value from the first array element and assign to key
                    String type = parts[1].trim(); //assign second array element to type
                    String name = parts[2].trim(); //assign third array element to name
                    TreeNode item = new TreeNode(key, type, name); //create a new TreeNode object with the above attributes
                    items.add(item); //add object to items array list
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < items.size(); i++) {
            TreeNode item = items.get(i); //iterate through array list of items
            tree.insert(item); //call insert on the created item
        }

        tree.printInOrderTraversal(); //call the print method that uses iterative in order traversal

        try {
            Scanner scanner = new Scanner(new File(file2)); //initialize reader in data file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); //split read line at each comma into an array of 3 strings
                if (parts.length == 3) {
                    long key = Long.parseLong(parts[0]); //assign parsed long value from first array element to key
                    keys.add(key); //add current key to key array list
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < keys.size(); i++) { //iterate through key array list
            TreeNode result = tree.search(tree.root,keys.get(i)); //call search method on the root of the tree and the current key
            System.out.print("Key: " + result.key); //print result's key
            if (result.type != "") { //if the result has a type
                System.out.print(", Type: " + result.type); //print the result's type
            }
            System.out.print(", Name: " + result.name); //print the result's name
            System.out.println(); //print empty line for ease of reading
        }

    }
}
