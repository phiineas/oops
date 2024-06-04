package questions.multithreading;

import java.util.ArrayList;
import java.util.Scanner;

public class question2 {
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

        final int[] min1 = {Integer.MAX_VALUE};
        final int[] min2 = {Integer.MAX_VALUE};
        int min = Integer.MAX_VALUE;
        
        Runnable r1 = new Runnable() {
            public void run() {
                for(int i = 0; i < numbers.size() / 3; i++) {
                    System.out.println("Thread 1 is currently comparing with: " + numbers.get(i) + " and the min for this thread is: "+ min1[0]);
                    if(numbers.get(i) < min1[0]) {
                        min1[0] = numbers.get(i);
                        System.out.println("The updated min value in Thread 1 is: " + min1[0]);
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                for(int i = numbers.size() / 3; i < 2 * numbers.size() / 3; i++) {
                    System.out.println("Thread 2 is currently comparing with: " + numbers.get(i) + " and the min for this thread is: "+ min2[0]);
                    if(numbers.get(i) < min2[0]) {
                        min2[0] = numbers.get(i);
                        System.out.println("The updated min value in Thread 2 is: " + min2[0]);
                    }
                }
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        for(int i = 2 * numbers.size() / 3; i < numbers.size(); i++) {
            System.out.println("Main Thread is currently comparing with: " + numbers.get(i) + " and the min for this thread is: "+ min);
            if(numbers.get(i) < min) {
                min = numbers.get(i);
                System.out.println("The updated min value in Main Thread is: " + min);
            }
        }

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int result = -1;
        if(min1[0] <= min2[0] && min1[0] <= min) {
            result = min1[0];
        } else if(min2[0] <= min1[0] && min2[0] <= min) {
            result = min2[0];
        } else {
            result = min;
        }

        System.out.println("Minimum number: " + result);
    }
}
