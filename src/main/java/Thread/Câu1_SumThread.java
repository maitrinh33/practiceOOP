package Thread;

class SumThread extends Thread {
    private final int n;
    private long sum;

    public SumThread(int n) {
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

public class Câu1_SumThread {
    public static void main(String[] args) {
        int n = 10; 
        SumThread thread = new SumThread(n);
        thread.start();
    }
}