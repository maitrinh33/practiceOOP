/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        this.denominator = denominator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    public Fraction add(Fraction f) {
        return new Fraction(numerator * f.denominator + f.numerator * denominator, denominator * f.denominator);
    }

    public Fraction sub(Fraction f) {
        return new Fraction(numerator * f.denominator - f.numerator * denominator, denominator * f.denominator);
    }

    public Fraction mul(Fraction f) {
        return new Fraction(numerator * f.numerator, denominator * f.denominator);
    }

    public Fraction div(Fraction f) {
        return new Fraction(numerator * f.denominator, denominator * f.numerator);
    }
}