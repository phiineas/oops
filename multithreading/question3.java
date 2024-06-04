package questions.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

public class question3 {
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

        final int[] max1 = {Integer.MIN_VALUE};
        final int[] max2 = {Integer.MIN_VALUE};
        int max = Integer.MIN_VALUE;
        
        Runnable r1 = new Runnable() {
            public void run() {
                for(int i = 0; i < numbers.size() / 3; i++) {
                    System.out.println("Thread 1 is currently comparing these: " + numbers.get(i) + " and the max for this thread is: "+ max1[0]);
                    if(numbers.get(i) > max1[0]) {
                        max1[0] = numbers.get(i);
                        System.out.println("The updated max value in Thread 1 is: " + max1[0]);
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for(int i = numbers.size() / 3; i < 2 * numbers.size() / 3; i++) {
                    System.out.println("Thread 2 is currently comparing these: " + numbers.get(i) + " and the max for this thread is: "+ max2[0]);
                    if(numbers.get(i) > max2[0]) {
                        max2[0] = numbers.get(i);
                        System.out.println("The updated max value in Thread 2 is: " + max2[0]);
                    }
                }
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        for(int i = 2 * numbers.size() / 3; i < numbers.size(); i++) {
            System.out.println("Main Thread is currently comparing these: " + numbers.get(i) + " and the max for this thread is: "+ max);
            if(numbers.get(i) > max) {
                max = numbers.get(i);
                System.out.println("The updated max value in Main Thread is: " + max);
            }
        }

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int result = -1;
        if(max1[0] >= max2[0] && max1[0] >= max) {
            result = max1[0];
        } else if(max2[0] >= max1[0] && max2[0] >= max) {
            result = max2[0];
        } else {
            result = max;
        }

        System.out.println("Maximum number: " + result);
    }
}
