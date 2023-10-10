import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class HW4 {

    private static int[] array;
    
    public static void main(String[] args) throws Exception {
        readFile("UPC.csv");
    }

    //TODO: read CSV file, split at regex, create an item object for each
    public static void readFile(String file) throws IOException {
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
            String str = reader.nextLine();
            String[] attributes = str.split(",");
            int key = Integer.parseInt(attributes[0]);
            String type = attributes[1];
            String name = attributes[2];
            Item.addItem(key,type,name);
        }
        reader.close();
        }
    }

    //TODO: read data file, split at regex, add to an array
}
