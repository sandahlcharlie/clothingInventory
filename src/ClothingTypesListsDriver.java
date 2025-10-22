import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClothingTypesListsDriver {

    private static Clothing getClothing(String[] parts, int type) {
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
        return item;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        ClothingTypesLists typesLists = new ClothingTypesLists();
        ClothingOrderedList clothingList = new ClothingOrderedList();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your file name (hint it is garments.txt): ");
        String fileName = input.nextLine();
        try{
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            int count = 0;
            int[] types = new int[25];



            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\t");
                int type = Integer.parseInt(parts[0].trim());
                types[count] = type;
                Clothing item = getClothing(parts, type);
                if(item instanceof Pants){
                    typesLists.add(item);
                } else if (item instanceof Shirt) {
                    typesLists.add(item);
                } else {
                    clothingList.add(item);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("PANTS LIST");
        ClothingOrderedList pantsList = typesLists.getList('p');
        typesLists.display(pantsList);
        System.out.println();

        System.out.println("SHIRT LIST");
        ClothingOrderedList shirtList = typesLists.getList('s');
        typesLists.display(shirtList);
        System.out.println();

        Pants khakis = new Pants("khakis", 15, 34);
        Shirt polo = new Shirt("polo", 8, true);
        typesLists.add(khakis);
        typesLists.add(2, polo);

        System.out.println("PANTS LIST");
        typesLists.display(pantsList);
        System.out.println();

        System.out.println("SHIRT LIST");
        typesLists.display(shirtList);
        System.out.println();

        System.out.println(typesLists.indexOf(khakis));
        System.out.println(typesLists.indexOf(polo));
        System.out.println(typesLists.sizeOf(pantsList));
        System.out.println(typesLists.sizeOf(shirtList));
        System.out.println(typesLists.get(pantsList, 6));
        System.out.println(typesLists.get(shirtList, 1));
        System.out.println(typesLists.remove(polo));
        System.out.println(typesLists.remove(shirtList, 7));

        System.out.println();
        System.out.println("PANTS LIST");
        typesLists.display(pantsList);
        System.out.println();

        System.out.println("SHIRT LIST");
        typesLists.display(shirtList);
        System.out.println();;
    }
}
