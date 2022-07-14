/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Katie S. Johnston
 * ITDEV-140 
 * Spring 2015
 * 5 - 8- 2015 */
public class Assignment14Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Get a Path object for the file
        // This file will be in the project folder.
        Path helloPath = Paths.get("hello.txt");   // Relative path
        File helloFile = helloPath.toFile();
        
        // Write data to the file
        // These lines create the file if it doesn't exist.
        // Next line is an example of layered streams.
        // See page 566 of Murach text. 
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(     // buffer to reduce IO operations.
                               new FileWriter(helloFile))))
        {
            out.println("Katie S. Johnston");
            // try-with-resources statement automatically closes the stream
            // and flushes data. 
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        // Read data from the file
        try (BufferedReader in = new BufferedReader(   // buffered input
                                 new FileReader(helloFile)))
        {
            String line = in.readLine();
            System.out.println(line);
            // try-with-resources automatically closes the stream. 
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    
}
