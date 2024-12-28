/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Nhap danh sach giao vien");
            System.out.println("3. In danh sach sinh vien");
            System.out.println("4. In danh sach giao vien");
            System.out.println("5. Thoat");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ten sinh vien: ");
                    String sName = scanner.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int sAge = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Nhap gioi tinh: ");
                    String sGender = scanner.nextLine();
                    System.out.print("Nhap lop: ");
                    String className = scanner.nextLine();
                    System.out.print("Nhap diem trung binh: ");
                    double averageScore = scanner.nextDouble();
                    students.add(new Student(sName, sAge, sGender, className, averageScore));
                }

                case 2 -> {
                    System.out.print("Nhap ten giao vien: ");
                    String tName = scanner.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int tAge = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Nhap gioi tinh: ");
                    String tGender = scanner.nextLine();
                    System.out.print("Nhap : ");
                    double salary = scanner.nextDouble();
                    teachers.add(new Teacher(tName, tAge, tGender, salary));
                }

                case 3 -> {
                    for (Student student : students) {
                        student.displayInfo();
                    }
                }

                case 4 -> {
                    for (Teacher teacher : teachers) {
                        teacher.displayInfo();
                    }
                }

                case 5 -> System.out.println("Thoat chuong trinh.");

                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 5);
    }
}
