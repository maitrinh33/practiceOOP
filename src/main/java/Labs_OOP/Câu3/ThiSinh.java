/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu3;

public class ThiSinh {
    private final String name;
    private final double mathScore;
    private final double physicsScore;
    private final double chemistryScore;

    public ThiSinh(String name, double mathScore, double physicsScore, double chemistryScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
    }

    public double totalScore() {
        return mathScore + physicsScore + chemistryScore;
    }

    public void displayInfo() {
        System.out.println("Ten: " + name + ", Tong diem: " + totalScore());
    }

    public String getName() {
        return name;
    }
}
