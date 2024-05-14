package questions.practical11;

import java.util.ArrayList;
import java.util.List;

public class practical11 {
    private static int sum1 = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }

        for (int i = 30; i < 50; i++) {
            sum1 += numbers.get(i);
            System.out.println(numbers.get(i));
        }
        
        Runnable r1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 15; i++) {
                    sum1 += numbers.get(i);
                    System.out.println("Thread 1: " + numbers.get(i));
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for (int i = 15; i < 30; i++) {
                    sum1 += numbers.get(i);
                    System.out.println("Thread 2: " + numbers.get(i));
                }
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final sum: " + sum1);
    }
}