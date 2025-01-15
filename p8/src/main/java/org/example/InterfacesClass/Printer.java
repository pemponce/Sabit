package org.example.InterfacesClass;

public interface Printer {
    void print(String text);

    static Printer A() {
        return text -> System.out.println(text);
    }

    static Printer B() {
        return text -> System.out.print(text);
    }

    static Printer C() {
        return text -> System.out.println("\t" + text);
    }

    static void main(String[] args) {
        Printer.A().print("Printer A");
        Printer.B().print("Printer B");
        Printer.C().print("Printer C");
    }
}
