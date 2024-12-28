/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Rectangle[] rectList = new Rectangle[10];
        for (int i = 0; i < rectList.length; i++) {
            double w = 100 * Math.random();
            double h = 100 * Math.random();
            rectList[i] = new Rectangle(w, h);
        }

        Arrays.sort(rectList);
        for (Rectangle rect : rectList) {
            System.out.println(rect.toString());
        }
    }
}
