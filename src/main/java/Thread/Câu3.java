/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import java.util.concurrent.atomic.AtomicInteger;

class PerfectNumberCounter implements Runnable {
    private final int start;
    private final int end;
    private final AtomicInteger count;

    public PerfectNumberCounter(int start, int end, AtomicInteger count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPerfect(i)) {
                count.incrementAndGet();
            }
        }
    }

    private boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num && num != 0;
    }
}

public class Câu3 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger perfectCount = new AtomicInteger(0);
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];
        int range = 300000 / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * range + 1;
            int end = (i + 1) * range;
            threads[i] = new Thread(new PerfectNumberCounter(start, end, perfectCount));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("So luong so hoan hao tu 1 den 300000 la: " + perfectCount.get());
    }
}
