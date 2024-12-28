/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;


import java.io.FileInputStream;
import java.io.IOException;

public class Câu3a {
    public static void main(String[] args) {
        String path = "src/main/java/UI/swing1/data.txt"; // Thay đổi đường dẫn

        try (FileInputStream fis = new FileInputStream(path)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
        }
    }
}