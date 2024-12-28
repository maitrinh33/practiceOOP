/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

class MyCircle {
    private int mPosX;
    private int mPosY;
    private int mRadius;

    public MyCircle() {
        this.mPosX = 0;
        this.mPosY = 0;
        this.mRadius = 10;
    }

    public MyCircle(int x, int y, int radius) {
        this.mPosX = x;
        this.mPosY = y;
        this.mRadius = radius;
    }

    public void display() {
        System.out.println("Circle at (" + mPosX + ", " + mPosY + ") with radius " + mRadius);
    }

    public void setX(int x) {
        this.mPosX = x;
    }

    public int getX() {
        return mPosX;
    }

    public void setY(int y) {
        this.mPosY = y;
    }

    public int getY() {
        return mPosY;
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
    }

    public int getRadius() {
        return mRadius;
    }

    public double distance(MyCircle c) {
        MyPoint center = new MyPoint(mPosX, mPosY);
        MyPoint otherCenter = new MyPoint(c.mPosX, c.mPosY);
        return center.distance(otherCenter);
    }

    public double area() {
        return Math.PI * mRadius * mRadius;
    }
}
