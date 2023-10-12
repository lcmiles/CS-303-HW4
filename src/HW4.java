import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class HW4 {
    
    public static void main(String[] args) throws Exception {
        readFile("UPC.csv");
    }

    //TODO: read CSV file, split at regex, create an item object for each
    public static void readFile(String file) throws IOException {
        try (Scanner reader = new Scanner(Paths.get(file))) {
            Item root = new Item(10, null, null);
            while (reader.hasNextLine()) {
                String str = reader.nextLine();
                String[] attributes = str.split(",");
                if (attributes.length >= 3) {
                    try {
                        long key = Long.parseLong(attributes[0]);
                        String type = attributes[1];
                        String name = attributes[2];
                        root.addItem(key, type, name);
                    } catch (NumberFormatException e) {
                        // Handle the case where the first element is not a valid long
                        System.err.println("Error parsing long: " + attributes[0]);
                    }
                } else {
                    // Handle the case where there are not enough elements in a line
                    System.err.println("Invalid line: " + str);
                }
            }
            reader.close();
            root.printItem();
        } catch (IOException e) {
            // Handle file-related exceptions
            e.printStackTrace();
        }
    }

    //TODO: read data file, split at regex, add to an array
}
