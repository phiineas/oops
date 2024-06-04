package questions.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

public class question4 {
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

        final int[] min = {Integer.MAX_VALUE};
        final int[] max = {Integer.MIN_VALUE};
        
        Runnable r1 = new Runnable() {
            public void run() {
                for(int i = 0; i < numbers.size(); i++) {
                    System.out.println("Thread 1 is currently comparing these: " + numbers.get(i) + " and the min for this thread is: "+ min[0]);
                    if(numbers.get(i) < min[0]) {
                        min[0] = numbers.get(i);
                        System.out.println("The updated max value in Thread 1 is: " + min[0]);
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for(int i = 0; i < numbers.size(); i++) {
                    System.out.println("Thread 2 is currently comparing these: " + numbers.get(i) + " and the max for this thread is: "+ max[0]);
                    if(numbers.get(i) > max[0]) {
                        max[0] = numbers.get(i);
                        System.out.println("The updated max value in Thread 2 is: " + max[0]);
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

        System.out.println("Minimum number: " + min[0]);
        System.out.println("Maximum number: " + max[0]);
    }
}
