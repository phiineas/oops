package questions;

import java.util.Random;
public class PlateNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        String plateNumber = "";

        for (int i = 0; i < 3; i++) {
            char c = (char)(rand.nextInt(26) + 'A');
            plateNumber += c;
        }

        for (int i = 0; i < 4; i++) {
            int n = rand.nextInt(10);
            plateNumber += Integer.toString(n);
        }

        System.out.println("Generated Plate Number: " + plateNumber);
    }
}
