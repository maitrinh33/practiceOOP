/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Handling;

import java.io.Serializable;

public class Student implements Serializable {
    private final String name;
    private final int age;
    private final double mark;

    public Student(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    // Getter/Setter
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMark() { return mark; }

    public void display() {
        System.out.println("Ten: " + name + ", Tuoi: " + age + ", Diem: " + mark);
    }
}