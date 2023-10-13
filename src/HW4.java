import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HW4 {

    static String file = "UPC.csv";
    static String file2 = "input.dat";
    static ArrayList<Long> keys = new ArrayList<Long>();


    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    long key = Long.parseLong(parts[0]);
                    String type = parts[1].trim();
                    String name = parts[2].trim();
                    tree.insert(key, type, name);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        tree.printInOrderTraversal();

        try {
            Scanner scanner = new Scanner(new File(file2));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    long key = Long.parseLong(parts[0]);
                    keys.add(key);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < keys.size(); i++) {
            TreeNode result = tree.search(tree.root,keys.get(i));
            System.out.print("Key: " + result.key);
            if (result.type != "") {
                System.out.print(", Type: " + result.type);
            }
            if (result.name != "") {
                System.out.print(", Name: " + result.name);
            }
            System.out.println();
        }

    }
}
