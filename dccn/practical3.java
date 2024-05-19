package questions.dccn;

import java.util.Scanner;

public class practical3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data bits: "); // 10110011
        String data = sc.nextLine();

        System.out.println("Enter the divisor: "); // 10011
        String divisor = sc.nextLine();

        System.out.println("Enter the transmitted data: ");
        String transmittedData = sc.nextLine();

        sc.close();
        
        receiver(transmittedData, divisor);
        for(int i=0 ; i<divisor.length()-1 ; i++) {
            data = data + "0";
        }
        String remainder = xor(data, divisor);
        System.out.println("CRC output: " +remainder);
    }

    public static String xor(String data, String divisor) {
        while(data.length() >= divisor.length()) {
            String temp = "";
            for(int i=0 ; i<divisor.length() ; i++) {
                if(data.charAt(i) == divisor.charAt(i)) {
                    temp = temp + "0";
                } else {
                    temp = temp + "1";
                }
            }
            data = temp + data.substring(divisor.length());
            data = data.replaceFirst("^0+(?!$)", ""); // remove leading zeros
        }
        return data;
    }

    public static void receiver(String transmittedData, String divisor) {
        String remainder = xor(transmittedData, divisor);
        if (Integer.parseInt(remainder) == 0) {
            System.out.println("Data is received without any error.");
        } else {
            System.out.println("Data is received with errors.");
        }
    }
}