/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class JavaFileCounter implements Runnable {
    private final File directory;
    private final AtomicInteger count;

    public JavaFileCounter(File directory, AtomicInteger count) {
        this.directory = directory;
        this.count = count;
    }

    @Override
    public void run() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    new Thread(new JavaFileCounter(file, count)).start();
                } else if (file.getName().endsWith(".java")) {
                    count.incrementAndGet();
                }
            }
        }
    }
}

public class Câu4 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger javaFileCount = new AtomicInteger(0);
        File directory = new File("src/main/java/Class_Object"); 
        Thread initialThread = new Thread(new JavaFileCounter(directory, javaFileCount));
        
        initialThread.start();
        initialThread.join(); 

        System.out.println("So luong file Java trong thu muc la: " + javaFileCount.get());
    }
}
