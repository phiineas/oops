package questions.extra;

abstract class q6a {
    abstract void method1();
    abstract void method2();

    void commonMethod() {
        System.out.println("This is a common method in abstract class");
    }
}

class SubClass extends q6a {
    void method1() {
        System.out.println("This is method1 implementation in subclass");
    }

    void method2() {
        System.out.println("This is method2 implementation in subclass");
    }
    
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method1();
        subClass.method2();
        subClass.commonMethod();
    }
}
