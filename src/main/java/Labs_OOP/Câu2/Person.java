/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu2;

public class Person {
    private final String name;
    private final int age;
    private final String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getter/Setter
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    public void displayInfo() {
        System.out.println("Ten: " + name + ", Tuoi: " + age + ", Gioi tinh: " + gender);
    }
}
