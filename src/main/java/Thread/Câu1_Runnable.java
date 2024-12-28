/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

class SumRunnable implements Runnable {
    private final int n;
    private long sum;

    public SumRunnable(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Tong tu 1 den " + n + " la: " + sum);
    }
}

public class Câu1_Runnable {
    public static void main(String[] args) {
        int n = 10; 
        Thread thread = new Thread(new SumRunnable(n));
        thread.start();
    }
}

