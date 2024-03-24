package questions;

interface Interface {
    void method1();
    void method2();
}

class ImplementingClass implements Interface {
    public void method1() {
        System.out.println("This is method1 implementation in implementing class");
    }

    public void method2() {
        System.out.println("This is method2 implementation in implementing class");
    }

    public static void main(String[] args) {
        ImplementingClass obj = new ImplementingClass();
        obj.method1();
        obj.method2();
    }
}
