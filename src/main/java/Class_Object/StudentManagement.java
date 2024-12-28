/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

// StudentManagement.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            System.out.println("--------------------------MENU--------------------------");
            System.out.println("1. Nhap sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Sinh vien co diem cao nhat");
            System.out.println("4. Sinh vien co diem thap nhat");
            System.out.println("5. Danh sach giam dan theo diem trung binh");
            System.out.println("6. Tim kiem");
            System.out.println("7. Viet Hoa ten sinh vien");
            System.out.println("8. Viet thuong ten sinh vien");
            System.out.println("9. Xoa sinh vien < 5 diem");
            System.out.println("-------------------------------------------------------");
            System.out.print("Chon: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    highestScoreStudent();
                    break;
                case 4:
                    lowestScoreStudent();
                    break;
                case 5:
                    sortStudents();
                    break;
                case 6:
                    searchStudent();
                    break;
                case 7:
                    uppercaseStudentName();
                    break;
                case 8:
                    lowercaseStudentName();
                    break;
                case 9:
                    removeLowScoreStudents();
                    break;
                default:
                    break;
            }
        } while (choice > 0 && choice < 10);
    }

    private void addStudent() {
        System.out.print("Nhap ten sinh vien: ");
        String name = scanner.nextLine();
        System.out.print("Nhap lop: ");
        String className = scanner.nextLine();
        System.out.print("Nhap diem trung binh: ");
        double averageScore = scanner.nextDouble();
        students.add(new Student(name, className, averageScore));
    }

    private void displayStudents() {
        for (Student student : students) {
            student.displayInfo();
        }
    }

    private void highestScoreStudent() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên rong.");
            return;
        }

        double highestScore = Collections.max(students, Comparator.comparingDouble(Student::getAverageScore)).getAverageScore();

        System.out.println("Sinh vien co diem cao nhat:");
        for (Student student : students) {
            if (student.getAverageScore() == highestScore) {
                student.displayInfo();
            }
        }
    }

    private void lowestScoreStudent() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh vien rong.");
            return;
        }

        double lowestScore = Collections.min(students, Comparator.comparingDouble(Student::getAverageScore)).getAverageScore();

        System.out.println("Sinh viên có diem thap nhat:");
        for (Student student : students) {
            if (student.getAverageScore() == lowestScore) {
                student.displayInfo();
            }
        }
    }

    private void sortStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh vien rong.");
            return;
        }

        students.sort(Comparator.comparingDouble(Student::getAverageScore).reversed());

        System.out.println("Danh sách sinh vien theo diem trung bình giam dan:");
        displayStudents();
    }

    private void searchStudent() {
        System.out.print("Nhap ten sinh vien can tim: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.displayInfo();
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    private void uppercaseStudentName() {
        System.out.print("Nhap ten sinh vien muon viet hoa: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.toUpperCaseName();
                System.out.println("Ten da duoc doi thanh: " + student.getName());
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    private void lowercaseStudentName() {
        System.out.print("Nhap ten sinh vien muon viet thuong: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.toLowerCaseName();
                System.out.println("Ten da duoc doi thanh: " + student.getName());
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    private void removeLowScoreStudents() {
        students.removeIf(student -> student.getAverageScore() < 5);
        System.out.println("Da xoa cac sinh vien co diem trung binh < 5.");
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.menu();
    }
}