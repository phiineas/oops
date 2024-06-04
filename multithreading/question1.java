package questions.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

public class question1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("How many numbers do you want to enter?");
        int n = sc.nextInt();

        System.out.println("Enter the numbers: ");

        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        sc.close();

        final int[] sum1 = {0};
        final int[] sum2 = {0};
        
        Runnable r1 = new Runnable() {
            public void run() {
                for(int i = 0; i < numbers.size(); i++) {
                    if(numbers.get(i) % 2 == 0) {
                        sum1[0] += numbers.get(i);
                        System.out.println("Adding on Thread 1: " + numbers.get(i));
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for(int i = 0; i < numbers.size(); i++) {
                    if(numbers.get(i) % 2 != 0) {
                        sum2[0] += numbers.get(i);
                        System.out.println("Adding on Thread 2: " + numbers.get(i));
                    }
                }
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Final sum: " + (sum1[0] + sum2[0]));
    }
}
