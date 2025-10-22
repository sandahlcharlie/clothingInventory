import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClothingOrderedListDriver {
    private static Clothing makeClothing(String line) {
        String[] parts = line.split("\\t");
        int type = Integer.parseInt(parts[0].trim());
        String name  = parts[1].trim();
        int stock    = Integer.parseInt(parts[2].trim());
        Clothing item;
        if (type == 1) {
            int length = Integer.parseInt(parts[3].trim());
            item = new Clothing(name, stock);
        } else if (type == 2) {
            boolean isLongSleeve = Boolean.parseBoolean(parts[3].trim());
            item = new Clothing(name, stock);
        } else {
            item = new Clothing(name, stock);
        }
        return item;
    }


    public static void main(String[] args) {
        ClothingOrderedList list = new ClothingOrderedList();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your file name (hint it is garments.txt): ");
        String fileName = input.nextLine();
        try{
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);


            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;
                Clothing item = makeClothing(line);
                list.add(item);
            }
        } catch(FileNotFoundException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }

        list.display();
        System.out.println();
        System.out.println();

        Clothing sweatpants = new Clothing("sweatpants", 5);
        Clothing tie = new Clothing("tie", 51);

        list.add(sweatpants);
        System.out.println(list.add(6, tie));
        list.display();
        System.out.println();
        System.out.println();

        System.out.println(list.remove(tie));
        System.out.println(list.remove(8));
        list.display();
        System.out.println();
        System.out.println();

        System.out.println(list.indexOf(sweatpants));
        System.out.println(list.indexOf(tie));

        System.out.println(list.get(14));

    }

}
