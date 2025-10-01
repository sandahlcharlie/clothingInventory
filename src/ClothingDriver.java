import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClothingDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your file name (hint it is garments.txt): ");
        String fileName = input.nextLine();
        ClothingSortedArraySet inventory = new ClothingSortedArraySet(25);
        try{
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            int[] types = new int[25];
            int count = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\t");
                int type = Integer.parseInt(parts[0].trim());
                types[count] = type;
                String name  = parts[1].trim();
                int stock    = Integer.parseInt(parts[2].trim());
                Clothing item;
                if (type == 1) {
                    int length = Integer.parseInt(parts[3].trim());
                    item = new Pants(name, stock, length);
                } else if (type == 2) {
                    boolean isLongSleeve = Boolean.parseBoolean(parts[3].trim());
                    item = new Shirt(name, stock, isLongSleeve);
                } else {
                    item = new Clothing(name, stock);
                }
                inventory.insert(item);
                count++;
            }
        } catch(FileNotFoundException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }

        System.out.println(inventory);


        System.out.println("indexOf(new Clothing(\"tshirt\", 3)) = " + inventory.indexOf(new Clothing("tshirt", 3)));
        System.out.println("indexOf(new Clothing(\"polo\", 2)) = " + inventory.indexOf(new Clothing("polo", 2)));
        System.out.println("remove(overalls,17) = " + inventory.remove(new Clothing("overalls", 17)));
        System.out.println("remove(socks,3) = " + inventory.remove(new Clothing("socks", 3)));
        System.out.println("categorySet type 3 (Clothing):\n" + inventory.categorySet(3));
        System.out.println("categorySet type 2 (Shirt):\n" + inventory.categorySet(2));

    }
}
