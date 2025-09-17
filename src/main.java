import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public static void main(String[] args) {
    // Make the clothing array
    ArrayList<Clothing> inventory = new ArrayList<>();

    // Read input from a user for a file
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your file name: ");
    String fileName = input.nextLine();

    // Make sure the file exists and add the
    try{
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNext()){
            String garment = fileScanner.next();
            int stock = fileScanner.nextInt();
            inventory.add(new Clothing(garment, stock));
        }
    } catch(FileNotFoundException e){
        System.out.println("Error reading the file: " + e.getMessage());
    }
    for(Clothing garment: inventory){
       System.out.println(garment);
    }
    Clothing[] ClothingArr = inventory.toArray(new Clothing[0]);

    // Testing methods for Array Driver
    System.out.println("We have an average of " + ClothingArrayDriver.overallAvg(ClothingArr) + " in stock across our " +
            "garment collection");
    System.out.println("We have " + ClothingArrayDriver.count(ClothingArr, new Clothing("tshirt", 9)) +
            " T-shirts that have 9 in stock");
    System.out.println("We have an average of " + ClothingArrayDriver.groupAvg(ClothingArr, "tshirt") + " in stock");
    System.out.println();
}