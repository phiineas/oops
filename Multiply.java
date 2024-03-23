package questions;

public class Multiply {
    private int result;

    public Multiply(int num1, int num2) {
        this.result = num1 * num2;
    }

    public int getResult() {
        return this.result;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply(5, 10);
        System.out.println("The result is: " + multiply.getResult());
    }
}
