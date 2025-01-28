package org.example.lection.before;

public class A {

    int x, y, z;
    int a, b, c;

    public A(int x, int y, int z, int a, int b, int c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void method1() {
        System.out.println("x: " + x + ", y: " + y);
    }

    void method2() {
        System.out.println("z: " + z);
    }

    void method3() {
        System.out.println("a: " + a + ", b: " + b + ", c: " + c);
    }

    public static void main(String[] args) {
        A a = new A(1,2,3,4,5,6);

        a.method1();
        a.method2();
        a.method3();
    }
}
