import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public static void main(String[] args) {
    // Make the clothing array
    ArrayList<Clothing> ClothingArr = new ArrayList<>();

    // Read input from a user for a file
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your file name:");
    String fileName = input.nextLine();

    // Make sure the file exists and add the
    try ())) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            String garment = parts[0];
            int stock = Integer.parseInt(parts[1]);
            ClothingArr.add(new Clothing(garment, stock));
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }



}