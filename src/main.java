import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public static void main(String[] args) {
    // Make the clothing array
    ArrayList<Clothing> ClothingArr = new ArrayList<>();

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
            ClothingArr.add(new Clothing(garment, stock));
        }
    } catch(FileNotFoundException e){
        System.out.println("Error reading the file: " + e.getMessage());
    }
    for(Clothing garment: ClothingArr){
       System.out.println(garment);
    }


}