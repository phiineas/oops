package questions.practical9;

import java.io.FileReader;
import java.io.IOException;

public class practical9a {

    // Method for unchecked exception
    public void handleUncheckedException(int a, int b) {
        try {
            int c = a / b;
            System.out.println(c);
        } catch(ArithmeticException e) {
            System.out.println("Division by zero");
        }
    }

    // Method for checked exception
    public void handleCheckedException(String filename) {
        try {
            FileReader file = new FileReader(filename);
            file.close();
        } catch(IOException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        practical9a practical9a = new practical9a();

        // Call method for unchecked exception
        practical9a.handleUncheckedException(10, 0);

        // Call method for checked exception
        practical9a.handleCheckedException("test.txt");
    }
}