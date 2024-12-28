/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

class MyPoint {
    private int mPosX;
    private int mPosY;

    public MyPoint() {
        this.mPosX = 0;
        this.mPosY = 0;
    }

    public MyPoint(int x, int y) {
        this.mPosX = x;
        this.mPosY = y;
    }

    public void display() {
        System.out.println("Coordinates: (" + mPosX + ", " + mPosY + ")");
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

    public double distance(MyPoint p) {
        return Math.sqrt(Math.pow(mPosX - p.mPosX, 2) + Math.pow(mPosY - p.mPosY, 2));
    }

    public static double distance(MyPoint p1, MyPoint p2) {
        return p1.distance(p2);
    }
}
