/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.IOException;
import java.nio.file.*;

public class Câu6 {
    public static void main(String[] args) {
        Path sourceDir = Paths.get("src/main/java/Class_Object"); 
        Path destinationDir = Paths.get("src/main/java/Empty_Folder"); 

        try {
            Files.walk(sourceDir).forEach(source -> {
                Path destination = destinationDir.resolve(sourceDir.relativize(source));
                try {
                    // Kiểm tra nếu là thư mục
                    if (Files.isDirectory(source)) {
                        // Tạo thư mục đích nếu nó không tồn tại
                        Files.createDirectories(destination);
                    } else {
                        // Sao chép tệp
                        Files.copy(source, destination);
                    }
                } catch (IOException e) {
                    System.err.println("Khong the sao chep duoc: " + source + " - " + e.getMessage());
                }
            });
            System.out.println("Sao chep thu muc thanh cong!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}