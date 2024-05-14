package questions.practical9;

public class practical9b {

    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            int x = 10;
            if (x > 5) {
                throw new MyException("Number is greater than 5");
            }
        } catch (MyException e) {
            System.out.println("Caught the exception: " + e.getMessage());
        }
    }
}