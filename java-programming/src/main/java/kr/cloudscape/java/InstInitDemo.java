package kr.cloudscape.java;

/**
 * What is Instance Initializer in Java? - https://www.programcreek.com/2011/10/java-class-instance-initializers/
 */
public class InstInitDemo {

    String s = "abc";

    static {
        System.out.println("Static Initializer called.");
    }

    {
        System.out.println("Instance Initializer called.");
    }

    public InstInitDemo() {
        System.out.println("Constructor called.");
    }

    public static void main(String[] args) {
        new InstInitDemo();
        new InstInitDemo();
    }
}
