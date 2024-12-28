/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

class MyRectangle {
    private MyPoint mPos;
    private int mWidth;
    private int mHeight;

    public MyRectangle() {
        this.mPos = new MyPoint(0, 0);
        this.mWidth = 100;
        this.mHeight = 100;
    }

    public MyRectangle(int x, int y, int width, int height) {
        this.mPos = new MyPoint(x, y);
        this.mWidth = width;
        this.mHeight = height;
    }

    public void display() {
        System.out.println("Rectangle at (" + mPos.getX() + ", " + mPos.getY() + ") with width " + mWidth + " and height " + mHeight);
    }

    public void setPos(MyPoint p) {
        this.mPos = p;
    }

    public MyPoint getPos() {
        return mPos;
    }

    public void setWidth(int w) {
        this.mWidth = w;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setHeight(int h) {
        this.mHeight = h;
    }

    public int getHeight() {
        return mHeight;
    }

    public double area() {
        return mWidth * mHeight;
    }
}
