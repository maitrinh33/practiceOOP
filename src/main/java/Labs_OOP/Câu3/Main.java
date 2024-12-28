/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ThiSinh> candidates = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Nhap so thi sinh: ");
        n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập ten thi sinh: ");
            String name = scanner.nextLine();
            System.out.print("Nhap diem Toan: ");
            double math = scanner.nextDouble();
            System.out.print("Nhap diem Ly: ");
            double physics = scanner.nextDouble();
            System.out.print("Nhap diem Hoa: ");
            double chemistry = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            candidates.add(new ThiSinh(name, math, physics, chemistry));
        }

        System.out.println("Danh sach thi sinh:");
        for (ThiSinh candidate : candidates) {
            candidate.displayInfo();
        }

        Collections.sort(candidates, Comparator.comparingDouble(ThiSinh::totalScore).reversed());
        System.out.println("Danh sach thi sinh diem giam dan:");
        for (ThiSinh candidate : candidates) {
            candidate.displayInfo();
        }

        System.out.println("Danh sach trung tuyen (diem chuan 17):");
        for (ThiSinh candidate : candidates) {
            if (candidate.totalScore() >= 17) {
                candidate.displayInfo();
            }
        }
    }
}