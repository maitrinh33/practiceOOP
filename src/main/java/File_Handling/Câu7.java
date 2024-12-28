/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Câu7 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Chuong trinh quan ly sinh vien");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Ghi danh sach xuong tep tin");
            System.out.println("4. Doc danh sach tu tep tin");
            System.out.println("5. Thoat");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ten sinh vien: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int age = scanner.nextInt();
                    System.out.print("Nhap diem: ");
                    double mark = scanner.nextDouble();
                    students.add(new Student(name, age, mark));
                }

                case 2 -> {
                    for (Student student : students) {
                        student.display();
                    }
                }

                case 3 -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
                        oos.writeObject(students);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                case 4 -> {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
                        students = (ArrayList<Student>) ois.readObject();
                        for (Student student : students) {
                            student.display();
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                case 5 -> System.out.println("Thoat chuong trinh.");

                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 5);
    }
} 