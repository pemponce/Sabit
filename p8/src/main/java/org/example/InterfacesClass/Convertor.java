package org.example.InterfacesClass;

public interface Convertor {
    String convert(Object arg);

    interface Convertors {
        static class Convertor1 implements Convertor {
            public String convert(Object arg) {
                return "Convertor1";
            }
        }

        static class Convertor2 implements Convertor {
            public String convert(Object arg) {
                return "Convertor2";
            }
        }

        static class Convertor3 implements Convertor {
            public String convert(Object arg) {
                return "Convertor3";
            }
        }
    }

    public static void main(String[] args) {
        Convertor convertor = new Convertor.Convertors.Convertor1();
        Convertor convertor2 = new Convertor.Convertors.Convertor2();
        Convertor convertor3 = new Convertor.Convertors.Convertor3();
        System.out.println(convertor.convert(null));
        System.out.println(convertor2.convert(null));
        System.out.println(convertor3.convert(null));
    }
}
