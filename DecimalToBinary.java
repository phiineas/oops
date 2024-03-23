package questions;

public class DecimalToBinary {
    public static void main(String[] args) {
        int num = 10;
        String binary = convertDecimalToBinary(num);
        System.out.println("Binary representation of " + num + " is " + binary);
    }

    public static String convertDecimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }

        String binary = "";
        while (n > 0) {
            int remainder = n % 2;
            binary = remainder + binary;
            n = n / 2;
        }

        return binary;
    }
}