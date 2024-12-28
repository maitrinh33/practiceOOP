/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.FileWriter;
import java.io.IOException;

public class Câu4a {
    public static void main(String[] args) {
        String content = "Hay dang ki khoa hoc ngay chi voi $0!\n";
        String path = "src/main/java/File_Handling/random.txt"; 

        try (FileWriter fw = new FileWriter(path)) {
            fw.write(content);
        } catch (IOException e) {
        }
    }
}
