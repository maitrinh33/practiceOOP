/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu1;

public abstract class Shape {
    abstract double area();
    
    @Override
    public String toString() {
        return "Dien tich: " + area();
    }
}
