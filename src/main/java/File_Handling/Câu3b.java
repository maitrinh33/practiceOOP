/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.FileReader;
import java.io.IOException;

public class Câu3b {
    public static void main(String[] args) {
        String path = "src/main/java/UI/swing1/data.txt"; 

        try (FileReader fr = new FileReader(path)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
        }
    }
}
