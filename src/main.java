import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public static void main(String[] args) {
    // Read input from a user for a file
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your file name:");
    String fileName = input.nextLine();

    // Make sure the file exists
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        System.out.println("\nContents of the file:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }


    ArrayList<ClothingArrayDriver> ClothingArr = new ArrayList<>();
}