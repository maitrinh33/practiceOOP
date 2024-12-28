/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.File;

public class Câu1 {
    public static void main(String[] args) {
        File directory = new File("src/main/java/Class_Object"); 

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            System.out.println("Noi dung thu muc: ");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Thu muc khong ton tai.");
        }
    }
}
