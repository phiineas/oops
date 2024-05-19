package questions.dccn;

import java.util.Scanner;

public class practical2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string: ");
        String data = sc.nextLine();
        sc.close();
        int[] ascii = Ascii(data);
        String[] binary = Binary(ascii);
        for(int i=0 ; i<ascii.length ; i++) {
            System.out.print(ascii[i] + " => Binary: " + binary[i] +"\n" );
        }
        // String[] binary = {"10101001","00111001"};
        BitAdd(binary); 
    }
    
    public static int[] Ascii(String data){
        int[] ascii = new int[data.length()];
        for(int i=0; i<data.length(); i++){
            ascii[i] = (int)data.charAt(i);
        }
        return ascii;
    }

    public static String[] Binary(int[] ascii){
        String[] binary = new String[ascii.length];
        for(int i=0; i<ascii.length; i++){
            binary[i] = String.format("%8s", Integer.toBinaryString(ascii[i])).replace(' ', '0');
    
        }
        return binary;
    }

    public static void BitAdd(String[] binary){
        String sum = "";
        String add = "00000000";
        char carry = '0';
        for(int i=0 ; i<binary.length ; i++){
            for(int j=7 ; j>=0 ; j--){
                if(binary[i].charAt(j) == '1' && add.charAt(j)=='1'){
                    if(carry == '0'){
                        carry = '1';
                    }else if(carry == '1'){
                        sum = "1"+sum;
                        continue;
                    }
                    sum = "0"+sum ;
                }else if(binary[i].charAt(j) == '0' && add.charAt(j)=='0'){
                    if(carry == '1'){
                        carry = '0';
                        sum = "1" + sum;
                        continue;
                    }
                    sum = "0"+sum;
                }else{
                    if(carry == '1'){
                        sum = "0"+ sum;
                        continue;
                    }
                    sum = "1"+sum;
                }
            }
            add = sum;
            sum = "";
        }

        // System.out.println(add);
        System.out.print("\nChecksum bit: ");
        for(int i=0 ; i<add.length() ; i++){
            if(add.charAt(i) == '0'){
                System.out.print("1");
            }else{
                System.out.print("0");
            }
        }
    }
}
