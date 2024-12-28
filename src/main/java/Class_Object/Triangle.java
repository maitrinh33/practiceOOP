/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public String type() {
        if (!isTriangle()) {
            return "Not a Triangle";
        }
        if (a == b && b == c) return "Equilateral";
        if (a == b || b == c || a == c) return "Isosceles";
        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) return "Right";
        return "Scalene";
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
