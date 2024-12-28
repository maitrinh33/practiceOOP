/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

// Student.java
public class Student {
    private String name;
    private String className;
    private double averageScore;

    public Student(String name, String className, double averageScore) {
        this.name = name;
        this.className = className;
        this.averageScore = averageScore;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Class: " + className + ", Average Score: " + averageScore);
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void toUpperCaseName() {
        this.name = name.toUpperCase();
    }

    public void toLowerCaseName() {
        this.name = name.toLowerCase();
    }
}



