import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW4 {

    static String file = "UPC.csv";

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
    }
}
