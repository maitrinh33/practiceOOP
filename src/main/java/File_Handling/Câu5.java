/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Câu5 {
    public static void main(String[] args) {
        Path source = Paths.get("src/main/java/File_Handling/FileA.txt");
        Path destination = Paths.get("src/main/java/File_Handling/FileB.txt"); 

        try {
            Files.copy(source, destination);
            System.out.println("Sao chep thanh cong!");
        } catch (IOException e) {
        }
    }
}