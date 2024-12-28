/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu2;

public class Student extends Person {
    private final String className;
    private final double averageScore;

    public Student(String name, int age, String gender, String className, double averageScore) {
        super(name, age, gender);
        this.className = className;
        this.averageScore = averageScore;
    }

    // Getter/Setter
    public String getClassName() { return className; }
    public double getAverageScore() { return averageScore; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Lop: " + className + ", Diem trung binh: " + averageScore);
    }
}
