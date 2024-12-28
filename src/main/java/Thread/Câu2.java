/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import java.util.concurrent.atomic.AtomicInteger;

class PrimeCounter implements Runnable {
    private final int start;
    private final int end;
    private final AtomicInteger count;

    public PrimeCounter(int start, int end, AtomicInteger count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count.incrementAndGet();
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

public class Câu2 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger primeCount = new AtomicInteger(0);
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];
        int range = 300000 / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * range + 1;
            int end = (i + 1) * range;
            threads[i] = new Thread(new PrimeCounter(start, end, primeCount));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("So luong so nguyen to tu 1 den 300000 la: " + primeCount.get());
    }
}