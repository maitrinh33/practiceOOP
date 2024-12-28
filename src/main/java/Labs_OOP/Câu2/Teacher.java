/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu2;

public class Teacher extends Person {
    private final double salary;

    public Teacher(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    // Getter/Setter
    public double getSalary() { return salary; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Luong: " + salary);
    }
}
