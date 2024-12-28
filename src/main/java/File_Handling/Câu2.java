/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Câu2 {
    public static void main(String[] args) {
        String path = "src/main/java/UI/swing1/data.txt";
        char characterToCount = 'i';
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int ch;
            while ((ch = br.read()) != -1) {
                if (ch == characterToCount) {
                    count++;
                }
            }
        } catch (IOException e) {
        }

        System.out.println("So ky tu '" + characterToCount + "' trong tep: " + count);
    }
}
