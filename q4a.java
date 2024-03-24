package questions;

public class q4a {
    private int result;

    public q4a(int num1, int num2) {
        this.result = num1 * num2;
    }

    public int getResult() {
        return this.result;
    }

    public static void main(String[] args) {
        q4a multiply = new q4a(5, 10);
        System.out.println("The result is: " + multiply.getResult());
    }
}
