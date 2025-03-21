// Kayla Jones
// CIS 2353
// Winter 2025
// Project 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PolynomialDemo {
    public static void main(String[] args) {
        //print contents of polynomial text file
        Scanner infile;
        String poly;

        try {
            infile = new Scanner(new File("C:/Users/kayla/CIS2353 Projects/CIS-2353-Data-Structures/proj2/polynomials.txt"));

            while(infile.hasNext()) {
                poly = infile.nextLine();
                System.out.println(poly);
            }

            infile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening file.");
        }
    }
}
