// Kayla Jones
// CIS 2353
// Winter 2025
// Project 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolynomialDemo {
    public static void main(String[] args) {
        ArrayList<Polynomial> polynomials = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // read polynomial text file and add
        // polynomials to arraylist
        try {
            File file = new File("polynomials.txt");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if(!line.isEmpty()) {
                    polynomials.add(new Polynomial(line));
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        while (true) { 
            System.out.println("List of Polynomials:\n");
            
            for(int i = 0; i < polynomials.size(); i++) {
                System.out.println(i + ": ");
                polynomials.get(i);
                System.out.println(); // blank space
            }

            // checking for valid user input
            System.out.println("Which do you wish to add? Press -1 to exit.");
            int index1 = input.nextInt();
            if(index1 == -1) break;

            int index2 = input.nextInt();
            if(index2 == -1) break;

            // checking is indices are out of bounds
            if(index1 < 0 || index1 >= polynomials.size() || index2 < 0 || index2 >= polynomials.size()) {
                System.out.println("Invalid indices. Please try again.");
            }

            // add polynomials together and show result on list
            //Polynomial result = new Polynomial(Polynomial.add(polynomials.get(index1), polynomials.get(index2)));
            //polynomials.add(result);
        }
    }
}
